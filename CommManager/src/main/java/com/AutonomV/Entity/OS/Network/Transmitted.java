package com.AutonomV.Entity.OS.Network;

import java.util.HashMap;
import java.util.Map;

public class Transmitted {

    private String bytes;
    private String packages;
    private String errors;
    private String dropped;
    private String carrier;
    private String collsns;

    /**
     * No args constructor for use in serialization
     */
    public Transmitted() {
    }

    /**
     * @param errors
     * @param packages
     * @param bytes
     * @param dropped
     * @param collsns
     * @param carrier
     */
    public Transmitted(String bytes, String packages, String errors, String dropped, String carrier, String collsns) {
        super();
        this.bytes = bytes;
        this.packages = packages;
        this.errors = errors;
        this.dropped = dropped;
        this.carrier = carrier;
        this.collsns = collsns;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getDropped() {
        return dropped;
    }

    public void setDropped(String dropped) {
        this.dropped = dropped;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCollsns() {
        return collsns;
    }

    public void setCollsns(String collsns) {
        this.collsns = collsns;
    }

}