package com.AutonomV.Entity.OS.Network;

import java.util.HashMap;
import java.util.Map;

public class NetworkInfo {

    private Received received;
    private Transmitted transmitted;

    /**
     * No args constructor for use in serialization
     */
    public NetworkInfo() {
    }

    /**
     * @param transmitted
     * @param received
     */
    public NetworkInfo(Received received, Transmitted transmitted) {
        super();
        this.received = received;
        this.transmitted = transmitted;
    }

    public Received getReceived() {
        return received;
    }

    public void setReceived(Received received) {
        this.received = received;
    }

    public Transmitted getTransmitted() {
        return transmitted;
    }

    public void setTransmitted(Transmitted transmitted) {
        this.transmitted = transmitted;
    }

}