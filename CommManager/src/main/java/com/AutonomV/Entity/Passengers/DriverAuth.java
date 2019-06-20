package com.AutonomV.Entity.Passengers;

/**
 * This Class is for the POJO of the Authentication Request of the Driver
 */
public class DriverAuth {
    private String id;
    private String timestamp;

    public DriverAuth(String id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
