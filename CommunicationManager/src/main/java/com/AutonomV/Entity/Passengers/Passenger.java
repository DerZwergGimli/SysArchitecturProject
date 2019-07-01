package com.AutonomV.Entity.Passengers;

public class Passenger {

    private String name;
    private String isPresent;
    private String timeStamp;

    /**
     * No args constructor for use in serialization
     */
    public Passenger() {
    }

    /**
     * @param timeStamp
     * @param name
     * @param isPresent
     */
    public Passenger(String name, String isPresent, String timeStamp) {
        super();
        this.name = name;
        this.isPresent = isPresent;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(String isPresent) {
        this.isPresent = isPresent;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}