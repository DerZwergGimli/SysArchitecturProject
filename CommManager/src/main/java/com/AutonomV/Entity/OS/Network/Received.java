package com.AutonomV.Entity.OS.Network;

import java.util.HashMap;
import java.util.Map;

public class Received {

    private String bytes;
    private String packages;
    private String errors;
    private String dropped;
    private String overrun;
    private String mcast;

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
    public Received(String bytes, String packages, String errors, String dropped, String overrun, String mcast) {
        super();
        this.bytes = bytes;
        this.packages = packages;
        this.errors = errors;
        this.dropped = dropped;
        this.overrun = overrun;
        this.mcast = mcast;
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

    public String getOverrun() {
        return overrun;
    }

    public void setOverrun(String overrun) {
        this.overrun = overrun;
    }

    public String getMcast() {
        return mcast;
    }

    public void setMcast(String mcast) {
        this.mcast = mcast;
    }

}