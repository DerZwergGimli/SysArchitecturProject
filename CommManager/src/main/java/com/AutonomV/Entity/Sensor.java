package com.AutonomV.Entity;

import java.util.HashMap;
import java.util.Map;

public class Sensor {

    private String name;
    private String value;
    private String unit;
    private String state;
    private String timestamp;
    /**
     * No args constructor for use in serialization
     */
    public Sensor() {
    }

    /**
     * @param timestamp
     * @param unit
     * @param name
     * @param state
     * @param value
     */
    public Sensor(String name, String value, String unit, String state, String timestamp) {
        super();
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.state = state;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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