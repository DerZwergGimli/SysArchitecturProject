package collisonAvoidance;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import gpioInterface.lidar.LidarSensor;
import redisInterface.IRedisDBInterface;

public class CollisionAvoidance implements ICollisonAvoidance {
	private int expireTimeRedis = 100;
	private String timestamp;
	private LidarSensor lidarSensor;

	private int frontMinDistance;
	private int frontLeftMinDistance;
	private int frontRightMinDistance;
	private int leftMinDistance;
	private int rightMinDistance;
	private int backMinDistance;
	private int backLeftMinDistance;
	private int backRightMinDistance;

	private ECollisonAvoidanceStaus frontStaus;
	private ECollisonAvoidanceStaus frontLeftStatus;
	private ECollisonAvoidanceStaus frontRightStaus;
	private ECollisonAvoidanceStaus leftStatus;
	private ECollisonAvoidanceStaus rightStatus;
	private ECollisonAvoidanceStaus backStatus;
	private ECollisonAvoidanceStaus backLeftStatus;
	private ECollisonAvoidanceStaus backRightStatus;

	public CollisionAvoidance(LidarSensor lidarSensor) {
		this.lidarSensor = lidarSensor;
		readPropertiesFile();
	}

	@Override
	public void checkAllSections() {

		frontStaus = checkFront();
		frontLeftStatus = checkFrontLeft();
		frontRightStaus = checkFrontRight();
		leftStatus = checkLeft();
		rightStatus = checkRight();
		backStatus = checkBack();
		backLeftStatus = checkBackLeft();
		backRightStatus = checkBackRight();
		generateTimestamp();
	}

	@Override
	public ECollisonAvoidanceStaus checkFront() {
		return check(330, 30, frontMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkFrontRight() {
		return check(30, 60, frontRightMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkFrontLeft() {
		return check(300, 330, frontLeftMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkLeft() {
		return check(240, 300, leftMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkRight() {
		return check(60, 120, rightMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkBack() {
		return check(150, 210, backMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkBackLeft() {
		return check(210, 240, backLeftMinDistance);
	}

	@Override
	public ECollisonAvoidanceStaus checkBackRight() {
		return check(120, 150, backRightMinDistance);
	}

	private ECollisonAvoidanceStaus check(int startAngle, int StopAngle, int minDistance) {
		int countOK = 0;
		int countNOK = 0;

		int[] distancesSection = lidarSensor.getDistancesBySection(startAngle, StopAngle);
		for (int distance : distancesSection) {
			if (distance > minDistance) {
				countOK++;
			}
			if (distance < minDistance) {
				countNOK++;
			}
		}
		if (countNOK == 0) {
			return ECollisonAvoidanceStaus.ok;
		} else {
			return ECollisonAvoidanceStaus.objectDetected;
		}
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		this.timestamp = dateFormat.format(new Date());
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			frontMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.Front_MinDistance"));
			frontLeftMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.FrontLeft_MinDistance"));
			frontRightMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.FrontRight_MinDistance"));

			leftMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.Left_MinDistance"));
			rightMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.Right_MinDistance"));

			backMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.Back_MinDistance"));
			backLeftMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.BackLeft_MinDistance"));
			backRightMinDistance = Integer.valueOf(properties.getProperty("collisonAvoidance.BackRight_MinDistance"));

			expireTimeRedis = Integer.valueOf(properties.getProperty("redis.expireTime"));
		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}

	@Override
	public void writeToDB(IRedisDBInterface redis) {
		String parentTopic = "sensors:collsionAvoidance:status:";

		redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
		redis.setAndExpire(parentTopic + "front", String.valueOf(frontStaus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "frontLeft", String.valueOf(frontLeftStatus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "frontRight", String.valueOf(frontRightStaus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "left", String.valueOf(leftStatus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "right", String.valueOf(rightStatus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "back", String.valueOf(backStatus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "backLeft", String.valueOf(backLeftStatus), expireTimeRedis);
		redis.setAndExpire(parentTopic + "backRight", String.valueOf(backRightStatus), expireTimeRedis);
	}

}