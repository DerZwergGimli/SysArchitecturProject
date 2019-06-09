package com.AutonomV.Entity.OS.Network;

import java.util.HashMap;
import java.util.Map;

public class Received {

    private int bytes;
    private int packages;
    private int errors;
    private int dropped;
    private int overrun;
    private String mcast;   // TODO: Change to Int ?
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Received() {
    }

    /**
     * @param errors
     * @param packages
     * @param bytes
     * @param dropped
     * @param overrun
     * @param mcast
     */
    public Received(int bytes, int packages, int errors, int dropped, int overrun, String mcast) {
        super();
        this.bytes = bytes;
        this.packages = packages;
        this.errors = errors;
        this.dropped = dropped;
        this.overrun = overrun;
        this.mcast = mcast;
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

    public int getOverrun() {
        return overrun;
    }

    public void setOverrun(int overrun) {
        this.overrun = overrun;
    }

    public String getMcast() {
        return mcast;
    }

    public void setMcast(String mcast) {
        this.mcast = mcast;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}