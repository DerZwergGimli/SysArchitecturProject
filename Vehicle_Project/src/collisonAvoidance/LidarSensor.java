package collisonAvoidance;

import redis.IRedisDBInterface;

public class LidarSensor implements ILidarSensor {

	int expireTimeRedis = 100;

	private int[] angles = new int[360];
	private int[] distances = new int[360];

	public LidarSensor() {
		for (int i = 0; i < angles.length; i++) {
			angles[i] = i;
		}
	}

	@Override
	public void setRandomDistances() {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = (int) ((Math.random() * 10) + 1);
		}
	}

	@Override
	public void printValues() {
		for (int i = 0; i < angles.length; i++) {
			System.out.println("Angle=" + angles[i] + "; Distances=" + distances[i]);
		}
	}

	@Override
	public void writeToDB(IRedisDBInterface redis) {
		String parentTopic = "sensors:lidar:";
		redis.setAndExpire(parentTopic + "distances", distancesToString(), expireTimeRedis);
		redis.setAndExpire(parentTopic + "angles", anglesToString(), expireTimeRedis);
	}

	private String distancesToString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int distance : distances) {
			stringBuilder.append(distance);
			stringBuilder.append(";");
		}
		return stringBuilder.toString();
	}

	private String anglesToString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int angle : angles) {
			stringBuilder.append(angle);
			stringBuilder.append(";");
		}
		return stringBuilder.toString();
	}

}
