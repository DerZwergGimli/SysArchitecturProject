package redisInterface;

/**
 * This is a Interface to interact with a redis-Database
 * 
 * @author yannick
 *
 */
public interface IRedisDBInterface {

	/**
	 * This will check if the redis database communication is enabled
	 * 
	 * @return
	 */
	public Boolean isEnabled();

	/**
	 * This will simply set an entire to the redis database by topic
	 * 
	 * @param topic
	 * @param variable
	 * @return
	 */
	public String set(String topic, String variable);

	/**
	 * This will set a entire to the redis database by topic with a time to expire
	 * in Seconds
	 * 
	 * @param topic
	 * @param variable
	 * @param secounds
	 * @return
	 */
	public String setAndExpire(String topic, String variable, int secounds);

	/**
	 * This will return a entire of the redis database by topic
	 * 
	 * @param topic
	 * @return
	 */
	public String get(String topic);

	/**
	 * This will close the connection to the redis database
	 */
	public void close();

}
