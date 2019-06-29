package redisInterface;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import redis.clients.jedis.Jedis;

public class RedisDBInterface implements IRedisDBInterface {

	private Logger logger;
	private Jedis jedisDB;
	private Boolean jedisServerEnabled;
	private String jedisURL;
	private int jedisPort;

	/**
	 * This will create a new connection to redis database as well as checking for a
	 * connection
	 * 
	 * @param logger
	 */
	public RedisDBInterface(Logger logger) {
		this.logger = logger;
		readPropertiesFile();

		if (jedisServerEnabled == true) {
			connect();
		} else {
			logger.log(Level.WARNING, "Redis DB is deactivated!");
		}
	}

	@Override
	public Boolean isEnabled() {
		return jedisServerEnabled;
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

		jedisDB.close();

	}

	public Boolean ping(RedisDBInterface redis) {
		try {
			String answer = jedisDB.ping();
			if (answer.contains("PONG")) {
				return true;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error while trying to connect to Redis-Server", e);
		}
		return false;

	}

	@Override
	public String set(String topic, String variable) {
		if (jedisServerEnabled == true) {
			try {
				return jedisDB.set(topic, variable);

			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error while writing to Redis DB", e);
			}
		}

		return "-1";
	}

	@Override
	public String setAndExpire(String topic, String variable, int secounds) {
		if (jedisServerEnabled == true) {
			try {
				return jedisDB.setex(topic, secounds, variable);

			} catch (Exception e) {
				logger.log(Level.SEVERE,
						"Error while writing to Redis DB and trying to set an expire for this variable", e);
			}
		}
		return "-1";
	}

	@Override
	public String get(String topic) {
		if (jedisServerEnabled == true) {
			try {
				return jedisDB.get(topic);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error while reading from Redis DB", e);
			}
		}
		return "-1";
	}

	@Override
	public void close() {
		if (jedisDB != null) {

			try {
				jedisDB.close();
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error while trying to close Redis DB connection", e);
			}
		}
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			this.jedisServerEnabled = Boolean.parseBoolean(properties.getProperty("redis.enable"));
			this.jedisURL = properties.getProperty("redis.url");
			this.jedisPort = Integer.valueOf(properties.getProperty("redis.port"));

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error while trying to read config of RedisDB", ex);

		}
	}

}
