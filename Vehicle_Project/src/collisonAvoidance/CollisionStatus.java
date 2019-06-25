package collisonAvoidance;

/**
 * This object is used to give some status back after a collionAvoidance check
 * Note: This object is used on sections
 * 
 * @author yannick
 *
 */
public class CollisionStatus {

	private ECollisonAvoidanceStaus eStatus;
	private int ok;
	private int nok;

	/**
	 * Constructor for the collionsStatus
	 * 
	 * @param ok
	 * @param nok
	 */
	public CollisionStatus(int ok, int nok) {
		this.ok = ok;
		this.nok = nok;
		this.eStatus = ECollisonAvoidanceStaus.error;
	}

	/**
	 * This will print a string of the status
	 * 
	 * @return
	 */
	public String convertToString() {
		float ratio = getRatio();
		String outputString = eStatus.toString() + "(" + ratio + ")";
		return outputString;
	}

	/**
	 * This will calculate the ratio of OK and NOK
	 * 
	 * @return
	 */
	public float getRatio() {
		try {
			return ok / nok;
		} catch (ArithmeticException e) {
			return 0;
		}

	}

	/**
	 * This will return the current status of collionAvoidance
	 * 
	 * @param eStatus
	 */
	public void setStatus(ECollisonAvoidanceStaus eStatus) {
		this.eStatus = eStatus;
	}

}
