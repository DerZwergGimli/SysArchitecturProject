package com.AutonomV.Communication;

import com.AutonomV.Entity.Passengers.DriverAuth;
import com.AutonomV.Util.Converter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComControllerTest {

    ComController mIstance;

    @Before
    public void setUp(){
        mIstance = new ComController("localhost","1888","AutonomV");
        mIstance.init("/V1/Driver/AuthResponse/", true);
    }

    @After
    public void after(){
        mIstance.close();
    }

    @Test
    public void initTest() {
        String broker = mIstance.getBroker();
        System.out.println("Broker found "+broker);
        Assert.assertEquals("Init Test-> broker-> "+broker,"tcp://localhost:1888",broker);
        //Assert.assertEquals("int test failed", true, mIstance.getConnectionStatus());
        System.out.println("Connection Status: "+mIstance.getConnectionStatus());
    }

    @Test
    public void publishTest() {
        DriverAuth driverAuth = new DriverAuth("973453", "20190607T134601Z");
        String authRequest = Converter.pojo2json(driverAuth);
        mIstance.publish("/V1/Driver/AuthRequest/", authRequest,2);
    }

    @Test
    public void closeTest() {
    }

    @Test
    public void getConnectionStatusTest() {
    }
}