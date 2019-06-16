package com.AutonomV.Entity;

import com.AutonomV.Entity.Passengers.Passenger;

import java.util.ArrayList;
import java.util.List;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class Vehicle {

    private List<Sensor> sensors = null;
    private List<Passenger> passengers = null;
    private Lidar lidar;

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
        if (sensors != null) {
            sensors.add(sensor);
        } else {
            sensors = new ArrayList<Sensor>();
            sensors.add(sensor);
        }
    }

    public void addPassengers(Passenger passenger) {
        if (passengers != null) {
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

}