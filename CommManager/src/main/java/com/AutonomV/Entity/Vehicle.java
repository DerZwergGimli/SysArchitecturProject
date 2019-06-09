package com.AutonomV.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class Vehicle {

    private List<Sensor> sensors = null;
    private Lidar lidar;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Vehicle() {
    }

    /**
     * @param sensors
     * @param lidar
     */
    public Vehicle(List<Sensor> sensors, Lidar lidar) {
        super();
        this.sensors = sensors;
        this.lidar = lidar;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Lidar getLidar() {
        return lidar;
    }

    public void setLidar(Lidar lidar) {
        this.lidar = lidar;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("sensors", sensors).append("lidar", lidar).append("additionalProperties", additionalProperties).toString();
//    }

}