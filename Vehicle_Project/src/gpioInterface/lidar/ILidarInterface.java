package gpioInterface.lidar;

public interface ILidarInterface {

	public Boolean isEnabled();

	public Boolean init();

	public Boolean startRotation();

	public Boolean stopRotation();

	public int[] scan();

}
