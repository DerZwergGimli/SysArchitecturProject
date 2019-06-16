package com.AutonomV.Communication;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * This Class controlls the Communication interface over MQTT
 */
public class ComController {

    private String host = "tcp://iot.eclipse.org";
    private String port = "1883";
    private String broker = host + ":" + port;
    private String clientId = "V1";
    private MemoryPersistence persistence;
    private MqttConnectOptions connOpts;

    private MqttClient mqttClient;
    private boolean connectionStatus;

    /**
     * No args constructor for use in serialization
     */
    public ComController() {
        this.connectionStatus = false;
    }

    public ComController(String host, String port, String clientId) {
        this.host = host;
        this.port = port;
        this.clientId = clientId;
        this.broker = "tcp://" + host + ":" + port;
        this.connectionStatus = false;
    }

    public void init(String topicFilter, boolean cleanSession) {
        // TODO: use evtl. user and Password
        try {
            persistence = new MemoryPersistence();
            connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(cleanSession);
            connOpts.setAutomaticReconnect(true);
            connOpts.setWill("/V1/Driver/LogoutRequest/", "Client got disconnected suddently".getBytes(), 2, true);
            mqttClient = new MqttClient(broker, clientId, persistence);
            mqttClient.setCallback(new ClientCallback());
            if (connect()) {
                // subscribe to /V1/Driver/AuthResponse/
                mqttClient.subscribe(topicFilter, 2);
            } else {
                System.out.println("Client couldn't connect to the Server");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to connect the Client to the Broker
     * This Method shall be used in the case when not using loop_forever
     *
     * @return true if connection was established, false if not.
     */
    public boolean connect() {
        try {
            if (mqttClient != null && !connectionStatus){
                System.out.println("Trying to connect..");
                mqttClient.connect(connOpts);
                connectionStatus = true;
                return true;
            }else {
                System.out.println("Client is null !");
                connectionStatus = false;
                return false;
            }

        } catch (MqttException e) {
            e.printStackTrace();
            connectionStatus = false;
            return false;
        }
    }

    /**
     * This Method pubishes a specific msg on a specific topic.
     *
     * @param topic The topic where the msg should be publiched
     * @param msg   The Payload that should be published
     */
    public void publish(String topic, String msg, int qos) {
        if (qos < 0 || qos > 2) {
            System.out.println("Invalid QoS: " + qos);
            // printHelp();
            return;
        }
        if (connectionStatus && mqttClient != null) {
            MqttMessage message = new MqttMessage(msg.getBytes());
            message.setQos(qos);
            System.out.println("Publishing message: " + msg);
            try {
                mqttClient.publish(topic, message);
            } catch (MqttException e) {
                e.printStackTrace();
                disconnect();
                close();
            }
        } else {
            System.out.println("Connection is lost or client is null");
        }

    }

    /**
     * This Method disconnects the Client from the Broker and throws an exception in case smth wrong happened.
     */
    private void disconnect() {
        try {
            System.out.println("Disconnecting..");
            mqttClient.disconnect();
            connectionStatus = false;

        } catch (MqttException e) {
            System.out.println("Exception when trying to disconnect the client");
            e.printStackTrace();
        }
    }

    public void close() {
        if (connectionStatus) {
            disconnect();
            try {
                System.out.println("Closing Client..");
                mqttClient.close();
            } catch (MqttException e) {
                System.out.println("Exception when trying to close the client");
                e.printStackTrace();
            }
        } else {
            try {
                mqttClient.close();
            } catch (MqttException e) {
                System.out.println("Exception when trying to close the client");
                e.printStackTrace();
            }
        }
    }

    public boolean getConnectionStatus() {
        return connectionStatus;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }
}
