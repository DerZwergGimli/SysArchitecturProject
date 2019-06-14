package com.AutonomV.Entity.OS;

import com.AutonomV.Entity.Sensor;

import java.util.HashMap;
import java.util.Map;

public class RealTimeData {

    private Sensor sensor;
    private String numOfRTThreads;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RealTimeData() {
    }

    /**
     * @param sensor
     * @param numOfRTThreads
     */
    public RealTimeData(Sensor sensor, String numOfRTThreads) {
        super();
        this.sensor = sensor;
        this.numOfRTThreads = numOfRTThreads;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getNumOfRTThreads() {
        return numOfRTThreads;
    }

    public void setNumOfRTThreads(String numOfRTThreads) {
        this.numOfRTThreads = numOfRTThreads;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
