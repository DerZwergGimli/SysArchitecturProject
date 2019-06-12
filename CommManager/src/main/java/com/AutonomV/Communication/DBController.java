package com.AutonomV.Communication;

import redis.clients.jedis.Jedis;

/**
 * This Class is a Child class of the Redis DB Controller "Jedis", and extends its fonctionality to fit in this Application
 */
public class DBController extends Jedis {

    private static DBController instance = null;

    public static DBController getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = (DBController) new Jedis("localhost", 6380);
            return instance;
        }
    }

    /**
     * This Method tests the Client connection to the DB by pinging the DB.
     *
     * @return should return "PONG" if the connection is established.
     */
    public String ping() {

        return super.ping();
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
        return super.set(key, variable);
    }

    /**
     * This method gets the variable with the key "key"
     * TODO: return enum ? OK,..
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return super.get(key);
    }


    public Long expire(String variableName, int timeSecounds) {
        System.out.println("Expire_: " + super.expire(variableName, timeSecounds));
        return null;
    }

    /**
     * Close the connection between the client and the DB
     */
    public void close() {
        super.close();
    }
}
