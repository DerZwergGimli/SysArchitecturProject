import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gpioInterface.lidar.LidarSensor;

public class lidarSensor {

	@Test
	public void lidarSensor_getDistances10To30_suceess() {
		LidarSensor lidarSensor = new LidarSensor();
		lidarSensor.setRandomDistances();

		int[] distancesSection = lidarSensor.getDistancesBySection(10, 30);

		assertEquals(distancesSection.length, 20);

	}

	@Test
	public void lidarSensor_getDistances349To10_suceess() {
		LidarSensor lidarSensor = new LidarSensor();
		lidarSensor.setRandomDistances();

		int[] distancesSection = lidarSensor.getDistancesBySection(349, 10);

		assertEquals(distancesSection.length, 21);

	}

	@Test
	public void lidarSensor_getDistances200To250_suceess() {
		LidarSensor lidarSensor = new LidarSensor();
		lidarSensor.setRandomDistances();

		int[] distancesSection = lidarSensor.getDistancesBySection(200, 250);

		assertEquals(distancesSection.length, 50);

	}
}
