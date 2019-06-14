package com.AutonomV.Entity;

import com.AutonomV.Entity.Passengers.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class Vehicle {

    private List<Sensor> sensors = null;
    private List<Passenger> passengers = null;
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

    public void addSensors(Sensor sensor) {
        if (sensors.size() != 0 && sensors != null) {
            sensors.add(sensor);
        } else {
            sensors = new ArrayList<Sensor>();
            sensors.add(sensor);
        }
    }

    public void addPassengers(Passenger passenger) {
        if (passengers.size() != 0 && passengers != null) {
            passengers.add(passenger);
        } else {
            passengers = new ArrayList<Passenger>();
            passengers.add(passenger);
        }
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
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