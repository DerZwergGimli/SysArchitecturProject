package collisonAvoidance;

import redisInterface.IRedisDBInterface;

/**
 * The interface for the collionAvoidance
 * 
 * @author yannick
 *
 */
public interface ICollisonAvoidance {

	/**
	 * Will check all present sections
	 */
	public void checkAllSections();

	/**
	 * Will check if there is a object in front
	 * 
	 * @return
	 */
	public CollisionStatus checkFront();

	/**
	 * Will check if there is a object on front-right
	 * 
	 * @return
	 */
	public CollisionStatus checkFrontRight();

	/**
	 * Will check if there is a object on front-left
	 * 
	 * @return
	 */
	public CollisionStatus checkFrontLeft();

	/**
	 * Will check if there is a object on left
	 * 
	 * @return
	 */
	public CollisionStatus checkLeft();

	/**
	 * Will check if there is a object on right
	 * 
	 * @return
	 */
	public CollisionStatus checkRight();

	/**
	 * Will check if there is a object on back
	 * 
	 * @return
	 */
	public CollisionStatus checkBack();

	/**
	 * Will check if there is a object on back-left
	 * 
	 * @return
	 */
	public CollisionStatus checkBackLeft();

	/**
	 * Will check if there is a object in back-right
	 * 
	 * @return
	 */
	public CollisionStatus checkBackRight();

	/**
	 * Will write all entries into the redis database
	 * 
	 * @param redis
	 */
	public void writeToDB(IRedisDBInterface redis);
}
