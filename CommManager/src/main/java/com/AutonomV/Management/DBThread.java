package com.AutonomV.Management;

import com.AutonomV.Communication.DBController;

public class DBThread extends Thread {

    DBController controller;

    public DBThread() {
        this.controller = DBController.getInstance();
    }
}
