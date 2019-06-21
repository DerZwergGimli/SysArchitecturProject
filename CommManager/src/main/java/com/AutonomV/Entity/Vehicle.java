package com.AutonomV.Entity;

import com.AutonomV.Entity.Passengers.Passenger;

import java.util.ArrayList;
import java.util.List;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class Vehicle {

    private List<Sensor> Sensors = null;
    private List<Passenger> Passengers = null;
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
        this.Sensors = sensors;
        this.lidar = lidar;
    }

    public void addSensors(Sensor sensor) {
        if (Sensors != null) {
            Sensors.add(sensor);
        } else {
            Sensors = new ArrayList<Sensor>();
            Sensors.add(sensor);
        }
    }

    public void addPassengers(Passenger passenger) {
        if (Passengers != null) {
            Passengers.add(passenger);
        } else {
            Passengers = new ArrayList<Passenger>();
            Passengers.add(passenger);
        }
    }

    public List<Sensor> getSensors() {
        return Sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.Sensors = sensors;
    }

    public Lidar getLidar() {
        return lidar;
    }

    public void setLidar(Lidar lidar) {
        this.lidar = lidar;
    }

    public List<Passenger> getPassengers() {
        return Passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.Passengers = passengers;
    }

}