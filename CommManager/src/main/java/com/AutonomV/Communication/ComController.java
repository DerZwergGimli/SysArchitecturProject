package com.AutonomV.Communication;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ComController {

    private String topic = "MQTT Examples";
    private String content = "Message from MqttPublishSample";
    private int qos = 2;
    private String broker = "tcp://iot.eclipse.org:1883";
    private String clientId = "V1";
    private MemoryPersistence persistence = new MemoryPersistence();
    private MqttClient sampleClient;
    private MqttConnectOptions connOpts;

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
    public void publish(String topic, String msg) {
        if (connectionStatus) {
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            System.out.println("Publishing message: " + content);
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


}
