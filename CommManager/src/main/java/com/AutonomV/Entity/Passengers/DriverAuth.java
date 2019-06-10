package com.AutonomV.Entity.Passengers;

/**
 * This Class is for the POJO of the Authentication Request of the Driver
 */
public class DriverAuth {
    private String id;
    private String timeStamp;

    public DriverAuth(String id, String timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
