package com.AutonomV.Management;


import com.AutonomV.Communication.ComController;

public class Manager {


    public static void main(String[] args) {

        ComController comController = new ComController("ea-pc165.ei.htwg-konstanz.de", "8883", "Autonom-V1");
        DataPersistanceThread dataPersistanceThread = new DataPersistanceThread(5000, comController);
        ManagementThread managementThread = new ManagementThread(comController);
        comController.init("/SysArch/V1/Driver/AuthResponse/", true, "V1", "DE1");

        managementThread.start();
        dataPersistanceThread.start();

    }
}