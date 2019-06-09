package com.AutonomV.Entity.OS.Network;

import java.util.HashMap;
import java.util.Map;

public class Transmitted {

    private int bytes;
    private int packages;
    private int errors;
    private int dropped;
    private String carrier;         // TODO: Change to Int ?
    private int collsns;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    public Transmitted(int bytes, int packages, int errors, int dropped, String carrier, int collsns) {
        super();
        this.bytes = bytes;
        this.packages = packages;
        this.errors = errors;
        this.dropped = dropped;
        this.carrier = carrier;
        this.collsns = collsns;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getDropped() {
        return dropped;
    }

    public void setDropped(int dropped) {
        this.dropped = dropped;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getCollsns() {
        return collsns;
    }

    public void setCollsns(int collsns) {
        this.collsns = collsns;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}