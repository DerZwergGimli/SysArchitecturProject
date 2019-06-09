package com.AutonomV.Management;

import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Entity.Driver;

/**
 * This Class extends the Thread Class and runs an infinite loop if not interrupted.
 * It retrievs the Data from the Redis DB, format it to JSON and pass it to the ComController to send it over MQTT.
 */
public class DBThread extends Thread {

    DBController controller;
    ComController comController;
    Boolean isDriverPresent;
    int state = NO_DRIVER;
    static final int NO_DRIVER = 0;
    static final int LOGIN = 1;
    static final int IS_LOGGED_IN = 2;


    public DBThread() {
        this.controller = DBController.getInstance();
    }

    @Override public void run(){
        while (true){

            // Check if Driver is present

            String id = controller.get("DriverID");

            switch (state){
                case NO_DRIVER:
                    if (checkDriver()){ state = LOGIN; };
                    break;
                case LOGIN:
                    if (login()){
                        state = IS_LOGGED_IN;

                    };
                    break;
                case IS_LOGGED_IN: ;
                default:;
            }






            controller.get("CPU:CPUtemperature");
        }
    }
    private boolean login(){
        // Send ID to the Management System

        return false;
    }

    private boolean checkDriver(){
        // check cyclically if the driver is pressent
        String isPresentResponse = controller.get("Driver:isPresent");
        if (!isPresentResponse.isEmpty() && Boolean.valueOf(isPresentResponse) ){
            // string is true if the string is not a null and equal to true (ignoring case).
            isDriverPresent = true ;
        }
        return false;
    }

    private void setDriver(){
        Driver driver = new Driver();

    }

    private void cyclicDataPersostance(){
        // Send Data in a time intervall of 500 ms

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

 class DriverAut{
    String id;
    String timeStamp;

    public DriverAut(String id, String timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }
}
