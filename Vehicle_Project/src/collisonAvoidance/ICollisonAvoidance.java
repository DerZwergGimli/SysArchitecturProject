package collisonAvoidance;

public interface ICollisonAvoidance {

	public ECollisonAvoidanceStaus checkFront();

	public ECollisonAvoidanceStaus checkFrontRight();

	public ECollisonAvoidanceStaus checkFronLeft();

	public ECollisonAvoidanceStaus checkLeft();

	public ECollisonAvoidanceStaus checkRight();

	public ECollisonAvoidanceStaus checkBack();

	public ECollisonAvoidanceStaus checkBackLeft();

	public ECollisonAvoidanceStaus checkBackRight();
}
