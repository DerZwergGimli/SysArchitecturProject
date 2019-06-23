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

public class CollisionAvoidance implements ICollisonAvoidance {
	private LidarSensor lidarSensor;

	private int frontMinDistance;
	private int frontLeftMinDistance;
	private int frontRightMinDistance;
	private int leftMinDistance;
	private int rightMinDistance;
	private int backMinDistance;
	private int backLeftMinDistance;
	private int backRightMinDistace;

	private String timestamp;

	public CollisionAvoidance(LidarSensor lidarSensor) {
		this.lidarSensor = lidarSensor;
	}

	@Override
	public ECollisonAvoidanceStaus checkFront() {
		int countOK = 0;
		int countNOK = 0;

		int[] distancesSection = lidarSensor.getDistancesBySection(330, 30);
		for (int distance : distancesSection) {
			if (distance < frontMinDistance) {
				countNOK++;
			}
			if (distance > frontMinDistance) {
				countOK++;
			}
		}
		if (countNOK == 0) {
			return ECollisonAvoidanceStaus.ok;
		} else {
			return ECollisonAvoidanceStaus.objectDetected;
		}
	}

	@Override
	public ECollisonAvoidanceStaus checkFrontRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkFronLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkBackLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECollisonAvoidanceStaus checkBackRight() {
		// TODO Auto-generated method stub
		return null;
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		timestamp = dateFormat.format(new Date());
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
			backRightMinDistace = Integer.valueOf(properties.getProperty("collisonAvoidance.BackRight_MinDistance"));

		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}

}