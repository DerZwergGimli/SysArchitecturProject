package collisonAvoidance;

import redisInterface.IRedisDBInterface;

public interface ICollisonAvoidance {

	public void checkAllSections();

	public ECollisonAvoidanceStaus checkFront();

	public ECollisonAvoidanceStaus checkFrontRight();

	public ECollisonAvoidanceStaus checkFrontLeft();

	public ECollisonAvoidanceStaus checkLeft();

	public ECollisonAvoidanceStaus checkRight();

	public ECollisonAvoidanceStaus checkBack();

	public ECollisonAvoidanceStaus checkBackLeft();

	public ECollisonAvoidanceStaus checkBackRight();

	public void writeToDB(IRedisDBInterface redis);
}
