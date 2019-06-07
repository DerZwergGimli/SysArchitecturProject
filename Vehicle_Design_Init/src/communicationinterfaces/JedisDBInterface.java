package communicationinterfaces;

import redis.clients.jedis.Jedis;

public class JedisDBInterface {

	Jedis jedisDB;

	public JedisDBInterface() {
		this.jedisDB = new Jedis("localhost", 32768);
	}

	public JedisDBInterface(String server, int port) {
		this.jedisDB = new Jedis(server, port);
	}

	public String ping() {
		return jedisDB.ping();
	}

	public String set(String name, String variable) {
		return jedisDB.set(name, variable);
	}

	public String get(String name) {
		return jedisDB.get(name);
	}

	public void expire(String variableName, int timeSecounds) {
		System.out.println("Expire_: " + jedisDB.expire(variableName, timeSecounds));
	}

	public void close() {
		jedisDB.close();
	}
}
