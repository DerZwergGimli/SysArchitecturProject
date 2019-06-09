package com.AutonomV.Entity.OS;

import com.AutonomV.Entity.Sensor;

import java.util.HashMap;
import java.util.Map;

public class CPU {

    private Sensor CPUtemperature;
    private String cPULoad;             // TODO: Change to Int ?
    private String cPUActiveCores;      // TODO: Change to Int ?
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CPU() {
    }

    /**
     * @param CPUtemperature
     * @param cPUActiveCores
     * @param cPULoad
     */
    public CPU(Sensor CPUtemperature, String cPULoad, String cPUActiveCores) {
        super();
        this.CPUtemperature = CPUtemperature;
        this.cPULoad = cPULoad;
        this.cPUActiveCores = cPUActiveCores;
    }

    public Sensor getCPUtemperature() {
        return CPUtemperature;
    }

    public void setCPUtemperature(Sensor CPUtemperature) {
        this.CPUtemperature = CPUtemperature;
    }

    public String getCPULoad() {
        return cPULoad;
    }

    public void setCPULoad(String cPULoad) {
        this.cPULoad = cPULoad;
    }

    public String getCPUActiveCores() {
        return cPUActiveCores;
    }

    public void setCPUActiveCores(String cPUActiveCores) {
        this.cPUActiveCores = cPUActiveCores;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}