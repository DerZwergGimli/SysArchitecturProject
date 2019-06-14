package com.AutonomV.Communication;

import com.AutonomV.Entity.Passengers.Driver;
import com.AutonomV.Management.ManagementThread;
import com.AutonomV.Util.Converter;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ClientCallback implements MqttCallback {

    private boolean isDriverPresent = false;

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Lost Connection to the server !..");
        System.out.println(throwable.getStackTrace());
        System.out.println("Cause: " + throwable.getCause());

        // TODO: Log Severe Error


    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        // TODO: check if use of .equalsIgnoreCase() is neccessairy gere
        /* Check if topic is: /V1/Driver/AuthResponse/ */
        if (topic.equals("/V1/Driver/AuthResponse/")) {
            // convert String to Pojo
            Driver allowedDriver = new Driver();
            String driverMsg = new String(mqttMessage.getPayload());
            System.out.println("Driver Json: " + driverMsg);
            allowedDriver = (Driver) Converter.json2pojo(driverMsg, allowedDriver);
            System.out.println("Driver: " + allowedDriver);
            ManagementThread.updateDriver(true, allowedDriver);
        }


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
