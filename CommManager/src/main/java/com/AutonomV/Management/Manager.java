package com.AutonomV.Management;


import com.AutonomV.Communication.ComController;

public class Manager {


    public static void main(String[] args) {

        ManagementThread managementThread = new ManagementThread();
        DataPersistanceThread dataPersistanceThread = new DataPersistanceThread();
        ComController comController = new ComController("localhost","1883","V1");
        comController.init("/V1/Driver/AuthResponse/",true);


        managementThread.start();
        dataPersistanceThread.start();


        return;
    }
}