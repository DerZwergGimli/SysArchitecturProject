package com.AutonomV.Entity.OS;

import com.AutonomV.Entity.Sensor;

public class CPU {

    private Sensor CPUtemperature;
    private String cPULoad;
    private String cPUActiveCores;

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

}