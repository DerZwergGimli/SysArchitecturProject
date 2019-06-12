package com.AutonomV.Util;

import com.AutonomV.Entity.Passengers.Driver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConverterTest {

    Driver driver = null;
    JSONObject jsonObject;
    String jsonString;


    @Before
    public void setUp() throws Exception {
        this.driver = new Driver(2334,"pojo1FirstName","pojo1LastName",345);

        jsonString = "{ \n" +
                " \"id\" : \"2334\",                    \n" +
                " \"firstName\"  : \"Karl\",           \n" +
                " \"lastName\"  : \"Eugen\",       \n" +
                " \"authLevel\"  : \"345\"               \n" +
                "}";
    }

    @Test
    public void testPojo2json() {
        String driverString = Converter.pojo2json(this.driver);
        System.out.println("JSONString:"+driverString);
        try {
            Driver newDriver = new ObjectMapper().readValue(driverString, Driver.class);
            // objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
            System.out.println("id:"+newDriver.getId());
            System.out.println("AuthLevel:"+newDriver.getAuthLevel());
            Assert.assertEquals("Driver ID not found or not identical", this.driver.getId(), newDriver.getId());
            Assert.assertEquals("Driver AuthLevel not found or not identical", this.driver.getAuthLevel(), newDriver.getAuthLevel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJson2pojo() {
        Driver testDriver = new Driver();
        testDriver = (Driver) Converter.json2pojo(jsonString, testDriver);
        System.out.println("testDriver: "+ testDriver.toString());
        Assert.assertEquals("Driver ID not found or not identical", this.driver.getId(), testDriver.getId());
        Assert.assertEquals("Driver AuthLevel not found or not identical", this.driver.getAuthLevel(), testDriver.getAuthLevel());


    }
}