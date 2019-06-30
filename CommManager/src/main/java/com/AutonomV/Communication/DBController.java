package com.AutonomV.Communication;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class is a Child class of the Redis DB Controller "Jedis", and extends its fonctionality to fit in this Application
 */
public class DBController {
    private final static String TAG = "DBController ";

    private static Logger logger;

    private static DBController instance = null;
    private Jedis jedis;
    private static String host = "localhost";
    private static int port = 6379;

    private DBController() {
        this.jedis = new Jedis(host, port,1800);
    }

    public static synchronized DBController getInstance() {
        if (instance != null) {
            System.out.println(TAG + "Jedis Controller exists");
            return instance;
        } else {
            System.out.println(TAG + "Initiating Jedis Controller on: " + host + ":" + port);
            instance = new DBController();
            return instance;
        }
    }

    public static void init(String mHost, int mPort, int timeout, Logger mLogger){
        logger = mLogger;
        host = mHost;
        port = mPort;
    }


    /**
     * This Method tests the Client connection to the DB by pinging the DB.
     *
     * @return should return "PONG" if the connection is established.
     */
    public String ping() {

        return jedis.ping();
    }

    /**
     * This Method sets the variable of key "key" with the value in "value"
     * TODO: return enum ? OK,..
     *
     * @param key key of the variable to be writen
     * @param variable Value of the variable to be writen
     * @return
     */
    public String set(String key, String variable) {
        return jedis.set(key, variable);
    }

    /**
     * This method gets the variable with the key "key"
     *
     * @param key key of the variable to be retrieved.
     * @return
     */
    public String get(String key) {
        try {
            if (jedis.isConnected()) {
                String res = jedis.get(key);
                if (res != null)
                    return res;
                else
                    return "0";

            } else {
                System.out.println("Connecting again...");
                this.jedis = new Jedis(host, port);
                return jedis.get(key);
            }
        } catch (JedisException ex) {
            System.out.println(TAG + "Exception thrown while trying to get Redis Variable: " + key);
            ex.printStackTrace();
            //System.out.println(ex.getStackTrace());
            return "0";
        }
    }

    /**
     *  This method checks if the Jedis Client is connected by pinging the server
     * @return true if the client is connected, false if not
     */
    public boolean isConnected() {
        String res = jedis.ping();
        System.out.println("Jedis Ping response: " + res);
        if (res.equalsIgnoreCase("pong"))
            return true;
        else
            return false;
    }

    /**
     * This method sets an expire timeout for the specific variable
     * @param variableName variable key
     * @param timeSecounds timeout to expire
     * @return
     */
    public Long expire(String variableName, int timeSecounds) {
        System.out.println(TAG + "Expire_: " + jedis.expire(variableName, timeSecounds));
        return null;
    }

    /**
     * Close the connection between the client and the DB
     */
    public void close() {
        System.out.println(TAG + "Closing DBController Connection");
        jedis.close();
    }
}
