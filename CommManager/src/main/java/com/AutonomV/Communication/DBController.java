package com.AutonomV.Communication;

import redis.clients.jedis.Jedis;

/**
 * This Class is a Child class of the Redis DB Controller "Jedis", and extends its fonctionality to fit in this Application
 */
public class DBController {
    private final static String TAG = "DBController ";

    private static DBController instance = null;
    private Jedis jedis;
    private String host;
    private int port;

    private DBController(String host, int port) {
        this.host = host;
        this.port = port;
        this.jedis = new Jedis(host, port);
    }

    public static synchronized DBController getInstance() {
        if (instance != null) {
            System.out.println(TAG + "Jedis Controller exists");
            return instance;
        } else {
            System.out.println(TAG + "Initiating Jedis Controller");
            instance = new DBController("localhost", 6380);
            return instance;
        }
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
     * @param key
     * @param variable
     * @return
     */
    public String set(String key, String variable) {
        return jedis.set(key, variable);
    }

    /**
     * This method gets the variable with the key "key"
     *
     * @param key
     * @return
     */
    public String get(String key) {
        if (jedis.isConnected()) {
            String res = jedis.get(key);
            if (res != null)
                return res;
            else
                return "0";

        } else {
            this.jedis = new Jedis(host, port);
            return jedis.get(key);
        }
    }


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
