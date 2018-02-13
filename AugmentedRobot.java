/* Copyright 2010, Joseph Bergin
 * Creative Commons Attribution-Noncommercial 3.0 United States License
 */

/**
 * Additional capabilities for a Robot. Note that some of these use ideas discussed in
 * Chapters 5 and 6 of the book.
 * 
 * @author Joseph Bergin
 * @version 1.0, January 2010
 */
public class AugmentedRobot extends Robot
{

	/** Create an EAST facing robot with no beepers */
	public AugmentedRobot()
	{
		super();
	}

	/**
	 * Create an EAST facing robot with a specified number of beepers
	 * 
	 * @param beepers the initial number of beepers in the beeper bag
	 */
	public AugmentedRobot(int beepers)
	{
		super(EAST, beepers);
	}

	/**
	 * Create a robot facing a given direction KarelWorld.EAST, KarelWorld.NORTH,
	 * KarelWorld.WEST, or KarelWorld.SOUTH, with no beepers.
	 * 
	 * @param direction the initial direction of the robot
	 */
	public AugmentedRobot(Direction direction)
	{
		super(direction);
	}

	/**
	 * Create a robot facing a given direction with a given number of beepers in its
	 * beeper bag. If the number of beepers is negative it will be interpreted as
	 * infinitely many beepers. You may also use the constant KarelWorld.INFINITE for
	 * infinitely many beepers.
	 * 
	 * @param direction the direction the robot will initially face
	 * @param beepers the initial number of beepers in the beeper bag
	 */
	public AugmentedRobot(Direction direction, int beepers)
	{
		super(direction, beepers);
	}

	/**
	 * Create a robot on a specific street and avenue, facing a given direction with a
	 * given number of beepers.
	 * 
	 * @param street the street on which to place the robot
	 * @param avenue the avenue on which to place the robot
	 * @param direction the direction the robot will initially face
	 * @param beepers the initial number of beepers in the beeper bag
	 */
	public AugmentedRobot(int street, int avenue, Direction direction,
			int beepers)
	{
		super(street, avenue, direction, beepers);
	}

	/** Turn around by executing two turnLeft instructions */
	public void turnAround()
	{
		turnLeft();
		turnLeft();
	}

	/** Turn right by executing three turnLeft instructions */
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	/** Back up if possible, and end facing the original direction. */
	public void backUp()
	{
		turnAround();
		move();
		turnAround();
	}

	/**
	 * Learn if the left side is clear or blocked.
	 * 
	 * @return true if the left side is clear
	 */
	public boolean leftIsClear()
	{
		turnLeft();
		if (frontIsClear())
		{
			turnRight();
			return true;
		} else
		{
			turnRight();
			return false;
		}
	}

	/**
	 * Learn if the right side is clear or blocked.
	 * 
	 * @return true if the right side is clear
	 */
	public boolean rightIsClear()
	{
		turnRight();
		if (frontIsClear())
		{
			turnLeft();
			return true;
		} else
		{
			turnLeft();
			return false;
		}
	}

	/** Face to the north by turning left repeatedly */
	public void faceNorth()
	{
		while (!facingNorth())
		{
			turnLeft();
		}
	}

	/** Face to the east by turning left repeatedly */
	public void faceEast()
	{
		while (!facingEast())
		{
			turnLeft();
		}
	}

	/** Face to the south by turning left repeatedly */
	public void faceSouth()
	{
		while (!facingSouth())
		{
			turnLeft();
		}
	}

	/** Face to the west by turning left repeatedly */
	public void faceWest()
	{
		while (!facingWest())
		{
			turnLeft();
		}
	}

}
