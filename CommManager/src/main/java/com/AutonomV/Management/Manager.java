package com.AutonomV.Management;


import com.AutonomV.Communication.DBController;

public class Manager {


    public static void main(String[] args) {

        DBThread dbThread = new DBThread();



        dbThread.start();

        System.out.println("hello wordl!");
    }
}