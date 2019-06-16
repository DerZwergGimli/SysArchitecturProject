package com.AutonomV.Entity;

public class Lidar {

    private String angleValue;
    private String angleUnit;
    private String distanceValue;
    private String distanceUnit;
    private String state;
    private String timestamp;

    /**
     * No args constructor for use in serialization
     */
    public Lidar() {
    }

    /**
     * @param timestamp
     * @param angleUnit
     * @param angleValue
     * @param state
     * @param distanceUnit
     * @param distanceValue
     */
    public Lidar(String angleValue, String angleUnit, String distanceValue, String distanceUnit, String state, String timestamp) {
        super();
        this.angleValue = angleValue;
        this.angleUnit = angleUnit;
        this.distanceValue = distanceValue;
        this.distanceUnit = distanceUnit;
        this.state = state;
        this.timestamp = timestamp;
    }

    public String getAngleValue() {
        return angleValue;
    }

    public void setAngleValue(String angleValue) {
        this.angleValue = angleValue;
    }

    public String getAngleUnit() {
        return angleUnit;
    }

    public void setAngleUnit(String angleUnit) {
        this.angleUnit = angleUnit;
    }

    public String getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(String distanceValue) {
        this.distanceValue = distanceValue;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}