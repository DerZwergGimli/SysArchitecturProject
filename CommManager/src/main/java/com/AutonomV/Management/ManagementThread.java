package com.AutonomV.Management;

import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Entity.Passengers.Driver;
import com.AutonomV.Entity.Passengers.DriverAuth;
import com.AutonomV.Util.Converter;

import java.util.logging.Logger;

/**
 * This Class extends the Thread Class and runs an infinite loop if not interrupted.
 * It retrievs the Data from the Redis DB, observes the Vehicle and driver and changes the state accordingly.
 */
public class ManagementThread extends Thread {

    private DBController dbController;
    private ComController comController;
    private Boolean isDriverPresent;
    private static Driver driver = null;
    private static boolean isDriverAllowed;

    private static int state;
    public static final int NO_DRIVER = 0;
    public static final int AUTHENTIFICATION = 1;
    public static final int IS_LOGGED_IN = 2;
    public static final int LOGOUT = 3;

    public ManagementThread(ComController comController, Logger logger) {
        this.dbController = DBController.getInstance();
        this.comController = comController;
        state = NO_DRIVER;
        this.isDriverPresent = false;
    }

    @Override
    public void run() {

        while (true) {
            switch (state) {
                case NO_DRIVER:
                    /* Send Data with low Frequency done in DataPersistenceThread*/
                    if (checkDriver()) {
                        state = AUTHENTIFICATION;
                    }
                    break;
                case AUTHENTIFICATION:
                    try {
                        if (authenticate()) {
                            state = IS_LOGGED_IN;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case IS_LOGGED_IN:
                    // Send Data with high frequency done in DataPersistanceThread
                    // Cyclc Check in DB if Driver is still present
                    if (!checkDriver()) {
                        state = LOGOUT;
                    }
                    break;
                case LOGOUT:
                    isDriverPresent = false;
                    ManagementThread.updateDriver(false, null);
                    // Send Logout Notification to the Management Server
                    // Change instead the variable isPresent in the passengers json
                    // =>This is done automatically by the RFID interface.
                    state = NO_DRIVER;
                    break;
                default:
                    System.out.println("System stuck in Default State");
                    // TODO: Log fatal error!

            }
        }
    }

    private boolean authenticate() throws InterruptedException {
        // Send ID to the Management System
        // Get Driver ID and the timestamp of the Login from DB
        DriverAuth driverAut = new DriverAuth(dbController.get("sensors:rfid:ID"), dbController.get("sensors:rfid:timestamp"));  // TODO dbController.get("Driver:timeStamp")
        String authRequest = Converter.pojo2json(driverAut);
        comController.publish("/SysArch/V1/Driver/AuthRequest/", authRequest, 2);
        /* Small Delay for Authentication Response*/
        Thread.sleep(1000);
        if (isDriverAllowed) {
            // Write Driver Info in DB
            writeDriverInfoInDB();
            return true;
        }
        return false;
    }

    private void writeDriverInfoInDB() {
        dbController.set("Driver:id", String.valueOf(driver.getId()));
        dbController.set("Driver:firstName", driver.getFirstName());
        dbController.set("Driver:lastName", driver.getLastName());
        dbController.set("Driver:authLevel", String.valueOf(driver.getAuthLevel()));
    }

    /**
     * This Method checks if the Driver is still present in the vehicle
     *
     * @return true if Driver is present, false if not.
     */
    private boolean checkDriver() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // check cyclically if the driver is pressent
        String isPresentResponse = dbController.get("sensors:rfid:present");
        // string is true if the string is not a null and equal to true (ignoring case).
        if ((isPresentResponse != null) && !isPresentResponse.isEmpty() && Boolean.valueOf(isPresentResponse)) {
            isDriverPresent = true;
            return true;
        } else {
            return false;
        }
    }

    public static void updateDriver(boolean isDriverAllowed, Driver driver) {
        ManagementThread.driver = driver;
        ManagementThread.isDriverAllowed = isDriverAllowed;
    }


    public static int getManagementState() {
        return state;
    }
}
