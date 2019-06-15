package com.AutonomV.Management;

import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Entity.Passengers.Driver;
import com.AutonomV.Entity.Passengers.DriverAuth;
import com.AutonomV.Util.Converter;

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

    private int state;
    public static final int NO_DRIVER = 0;
    public static final int AUTHENTIFICATE = 1;
    public static final int IS_LOGGED_IN = 2;
    public static final int LOGOUT = 3;

    public ManagementThread() {
        this.dbController = DBController.getInstance();
        this.comController = new ComController(); // TODO: call Constructor with parameters
        this.state = NO_DRIVER;
        this.isDriverPresent = false;
    }

    @Override
    public void run() {

        while (true) {

            String id = dbController.get("DriverID");

            switch (state) {
                case NO_DRIVER:
                    /* Send Data with low Frequency */
                    cyclicDataPersistance();
                    // Timeinterval for cyclic data persistance
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // In this case the Check will be ade every 5 sec which is not sufficient
                    // TODO: Make a seperate Thread for Data Persistance
                    // Idea : Thread with attribute interval, which can be set accordingly to the state.
                    if (checkDriver()) {
                        state = AUTHENTIFICATE;
                    }
                    break;
                case AUTHENTIFICATE:
                    try {
                        if (authenticate()) {
                            state = IS_LOGGED_IN;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                    break;
                case IS_LOGGED_IN:
                    // TODO: Send Data with high frequency
                    cyclicDataPersistance();
                    // Timeinterval for cyclic data persistance
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
        DriverAuth driverAut = new DriverAuth(dbController.get("Driver:id"), dbController.get("Driver:timeStamp"));
        String authRequest = Converter.pojo2json(driverAut);
        if (comController.getConnectionStatus()) {
            comController.publish("/V1/Driver/AuthRequest/", authRequest, 2);
            /* Small Delay for Authentication Response*/
            Thread.sleep(1000);
            if (isDriverAllowed) {
                // Write Driver Info in DB
                writeDriverInfoInDB();
                return true;
            }
        } else {
            System.out.println("Client has no conection to the Server");
            // TODO: Log severe error!
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
        // check cyclically if the driver is pressent
        String isPresentResponse = dbController.get("Driver:isPresent");
        // string is true if the string is not a null and equal to true (ignoring case).
        if (!isPresentResponse.isEmpty() && Boolean.valueOf(isPresentResponse)) {
            isDriverPresent = true;
            return true;
        } else {
            return false;
        }
    }

    private void cyclicDataPersistance() {
        // TODO: move to DataPersistanceThread
        dbController.get("CPU:CPUtemperature");
        // ...
    }

    public static void updateDriver(boolean isDriverAllowed, Driver driver) {
        ManagementThread.driver = driver;
        ManagementThread.isDriverAllowed = isDriverAllowed;
    }

}
