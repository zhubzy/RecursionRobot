/* Copyright 2010, Joseph Bergin
 * Creative Commons Attribution-Noncommercial 3.0 United States License
 */

/**
 * This is a collection of robot tasks as static methods. It illustrates one way to use
 * this system and was used to test it during creation.
 * 
 * @author Joseph Bergin
 * @version 1.0, January 2010
 */
public class ManyTasks implements Direction
{

	/**
	 * Constructor for objects of class ManyTasks
	 */
	private ManyTasks()
	{
	}

	/** The beginning of a solution to Exercise 2-1 of Karel J Robot */
	public static void getBeeper()
	{
		KarelWorld world = KarelWorld.itself();
		world.readWorld("worlds", "fig2-6.kwld");
		UrRobot karel = new UrRobot(2, 7, KarelWorld.WEST, 0);

		karel.move();
		karel.turnLeft();
		// more
	}

	/**
	 * An example of a task for a robot using Chapter 2 ideas. Start of a solution to
	 * Problem 2-5
	 * 
	 */
	public static void newspaperRetrievalTask()
	{
		KarelWorld world = KarelWorld.itself();
		world.readWorld("worlds", "newspaperworld.kwld");
		UrRobot karel = new UrRobot(3, 4, WEST, 0);

		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		// more to do here
	}

	/**
	 * Walk around the perimeter of the world and pick a single beeper from any corner on
	 * which it finds any. (Chapter 6 ideas here)
	 */
	public static void perambulateWorld()
	{
		Robot karel = new Robot(3, 4, WEST, 0);

		for (int i = 0; i < 6; ++i)
		{
			while (karel.frontIsClear())
			{
				if (karel.nextToABeeper())
				{
					karel.pickBeeper();
				}
				karel.move();
			}
			karel.turnLeft();
		}
	}
}
