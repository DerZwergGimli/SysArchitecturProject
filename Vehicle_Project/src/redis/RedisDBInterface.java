package redis;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import redis.clients.jedis.Jedis;

public class RedisDBInterface implements IRedisDBInterface {
	private Logger logger;
	private Jedis jedisDB;
	private String jedisURL;
	private int jedisPort;

	public RedisDBInterface(Logger logger) {
		this.logger = logger;
		readPropertiesFile();
		connect();
		// jedisDB.ping();
	}

	private void connect() {
		jedisDB = new Jedis(jedisURL, jedisPort);

		try {
			String answer = jedisDB.ping();
			if (answer.contains("PONG")) {
				;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while trying to connect to Redis-Server", e);
		}

	}

	@Override
	public String set(String name, String variable) {
		try {
			return jedisDB.set(name, variable);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while writing to Redis DB", e);
		}
		return "-1";
	}

	@Override
	public String setAndExpire(String name, String variable, int secounds) {
		try {
			return jedisDB.setex(name, secounds, variable);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while writing to Redis DB and trying to set an expire for this variable",
					e);
		}
		return "-1";
	}

	@Override
	public String get(String name) {
		try {
			return jedisDB.get(name);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while reading from Redis DB", e);
		}
		return "-1";
	}

	@Override
	public void expire(String variableName, int timeSecounds) {
		System.out.println("Expire_: " + jedisDB.expire(variableName, timeSecounds));
	}

	@Override
	public void close() {
		try {
			jedisDB.close();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while trying to close Redis DB connection", e);
		}
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			this.jedisURL = properties.getProperty("redis.url");
			this.jedisPort = Integer.valueOf(properties.getProperty("redis.port"));

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error while trying to read config of RedisDB", ex);

		}
	}

}
