package com.AutonomV.Communication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DBControllerTest {
    DBController mInstance;

    @Before
    public void setUp() throws Exception {
        mInstance = DBController.getInstance();
        mInstance.set("var1", "100");
    }

    @Test
    public void ping() {
        String res = mInstance.ping();
        System.out.println("res: " + res);
        Assert.assertEquals("Wrong response bei Ping: " + res, "PONG", res);
    }

    @Test
    public void set() {
        mInstance.set("var1", "100");
        String actual = mInstance.get("var1");
        Assert.assertEquals("Set Method not successful, result read: " + actual, "100", actual);
    }

    @Test
    public void get() {
        String actual = mInstance.get("sensors:rfid:present");
        Assert.assertEquals("Get Method not successful, result read: " + actual, "true", actual);
    }

    @Test
    public void close() {
    }
}