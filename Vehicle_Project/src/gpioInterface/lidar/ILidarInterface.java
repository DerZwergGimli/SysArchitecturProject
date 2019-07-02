package gpioInterface.lidar;

/**
 * This interface is used to communicate with the lidar sensor on a RPI
 * 
 * @author yannick
 *
 */
/**
 * @author yannick
 *
 */
public interface ILidarInterface {

	/**
	 * This will check if the lidar sensor should be usable
	 * 
	 * @return
	 */
	public Boolean isEnabled();

	/**
	 * This will setup the PWM on GPIO-PIN of a RPI
	 * 
	 * @return
	 */
	public Boolean init();

	/**
	 * This will start the rotation of the lidar sensor
	 * 
	 * @return
	 */
	public Boolean startRotation();

	/**
	 * This will stop the rotation of the lidar sensor
	 * 
	 * @return
	 */
	public Boolean stopRotation();

	/**
	 * This will return a 360deg scan of the lidar sensor with 360Values
	 * 
	 * @return
	 */
	public int[] scan();

	/**
	 * This will generate random values
	 * 
	 * @return
	 */
	public int[] generateRandomDistances();

}
