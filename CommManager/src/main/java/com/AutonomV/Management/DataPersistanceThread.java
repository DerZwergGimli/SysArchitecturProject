package com.AutonomV.Management;

/**
 * This Class extends the Thread Class and runs an infinite loop if not interrupted.
 * The Interval can be changed depending on the State from the ManagementThread.
 * It retrievs the Data from the Redis DB, format it to JSON and pass it to the ComController to send it over MQTT.
 */
public class DataPersistanceThread extends Thread {
    private int interval;


    @Override public void run()
    {

    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
