package redis;

public interface IRedisDBInterface {

	public String set(String name, String variable);

	public String setAndExpire(String name, String variable, int secounds);

	public String get(String name);

	public void expire(String variableName, int timeSecounds);

	public void close();

}
