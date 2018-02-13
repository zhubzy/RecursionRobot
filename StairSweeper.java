/* Copyright 2010, Joseph Bergin. All rights reserved.
 * 
 */

/**
 * A StairSweeper knows how to climb one stair. This is a sample
 * illustration of one way to use this system. Note that the Greenfoot Run command/button
 * is not useful with this class. Use the Act command/button.
 * 
 * @author Joseph Bergin
 * @version 1.0 (Greenfoot) January 2010
 */
public class StairSweeper extends UrRobot
{
/** Create a stair sweeper at the base of the steps */
	public StairSweeper()
	{
		super(1, 2, EAST, 0);
		populate(); // You can populate the world here rather than making a separate
		// call.
	}

	/** Print a short usage note to standard output. */
	public static String usage()
	{
		System.out.println();
		System.out.println("Use the populate() method to load a suitable world.");
		System.out.println("     Or, build a world by hand.");
		System.out.println("     Or, use the world's readWorld method to get a world.");
		System.out.println("Then drag a StairSweeper to street 1, avenue 2.");
		System.out.println("Set the speed to a suitable value.");
		System.out.println("Then push the Act button at the bottom of the window.");
		return "See the output listing.";
	}

	/** Turn 90 degrees to the right */
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	/** Climb one stair */
	public void climbStair()
	{
		turnLeft();
		move();
		turnRight();
		move();
	}

	/**
	 * Convenience method to get an appropriate world for the StairSweeper.
	 */
	public static void populate()
	{
		KarelWorld world = KarelWorld.itself();
		world.readWorld("worlds", "stairworld.kwld");
	}

	/**
	 * Act - Climb exactly three stairs, picking a beeper from each. The stairworld.kwld
	 * file contains a suitable world.
	 */
	public void act()
	{
		climbStair();
		pickBeeper();
		climbStair();
		pickBeeper();
		climbStair();
		pickBeeper();
		turnOff();
	}
}
