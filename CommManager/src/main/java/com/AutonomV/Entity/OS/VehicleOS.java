package com.AutonomV.Entity.OS;

import com.AutonomV.Entity.OS.Network.NetworkInfo;

import java.util.HashMap;
import java.util.Map;

public class VehicleOS {

    private CPU cPU;
    private NetworkInfo network;
    private RealTimeData rT;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VehicleOS() {
    }

    /**
     * @param rT
     * @param network
     * @param cPU
     */
    public VehicleOS(CPU cPU, NetworkInfo network, RealTimeData rT) {
        super();
        this.cPU = cPU;
        this.network = network;
        this.rT = rT;
    }

    public CPU getCPU() {
        return cPU;
    }

    public void setCPU(CPU cPU) {
        this.cPU = cPU;
    }

    public NetworkInfo getNetwork() {
        return network;
    }

    public void setNetwork(NetworkInfo network) {
        this.network = network;
    }

    public RealTimeData getRT() {
        return rT;
    }

    public void setRT(RealTimeData rT) {
        this.rT = rT;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
