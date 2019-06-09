package com.AutonomV.Communication;

import com.AutonomV.Entity.Driver;
import com.AutonomV.Util.Converter;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ComController {

    private String broker = "tcp://iot.eclipse.org:1883";
    private String clientId = "V1";
    private MemoryPersistence persistence = new MemoryPersistence();
    private MqttClient sampleClient;
    private MqttConnectOptions connOpts;


    private Driver driver;

    private boolean connectionStatus = false;

    /**
     * No args constructor for use in serialization
     */
    public ComController() {
    }


    /**
     * Method to connect the Client to the Broker
     * This Method shall be used in the case when not using loop_forever
     *
     * @return
     */
    public boolean connect() {
        try {
            sampleClient.connect(connOpts);
            connectionStatus = true;
            return true;
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This Method pubishes a specific msg on a specific topic.
     *
     * @param topic
     * @param msg
     */
    public void publish(String topic, String msg, int qos) {
        if (qos < 0 || qos > 2) {
            System.out.println("Invalid QoS: "+qos);
            // printHelp();
            return;
        }
        if (connectionStatus) {
            MqttMessage message = new MqttMessage(msg.getBytes());
            message.setQos(qos);
            System.out.println("Publishing message: " + msg);
            try {
                sampleClient.publish(topic, message);
            } catch (MqttException e) {
                e.printStackTrace();
                disconnect();
            }
        } else {
            System.out.println("Connection is lost");
        }

    }

    /**
     * This Method disconnects the Client from the Broker and throws an exception in case smth wrong happened.
     */
    public void disconnect() {
        try {
            sampleClient.disconnect();
            System.out.println("Disconnected");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callback function to be called when the Authentification of the driver was successful
     */
    private void driverAuthCallback(){
        String msgString = null;
        this.driver = (Driver) Converter.json2pojo(msgString, driver);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
