package redisInterface;

public interface IRedisDBInterface {

	public Boolean isEnabled();

	public String set(String name, String variable);

	public String setAndExpire(String name, String variable, int secounds);

	public String get(String name);

	public void close();

}
