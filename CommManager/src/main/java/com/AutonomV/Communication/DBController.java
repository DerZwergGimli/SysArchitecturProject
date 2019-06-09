package com.AutonomV.Communication;

import redis.clients.jedis.Jedis;

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

    public String ping() {

        return super.ping();
    }

    public String set(String name, String variable) {
        return super.set(name, variable);
    }

    public String get(String name) {
        return super.get(name);
    }


    public Long expire(String variableName, int timeSecounds) {
        System.out.println("Expire_: " + super.expire(variableName, timeSecounds));
        return null;
    }

    public void close() {
        instance.close();
    }
}
