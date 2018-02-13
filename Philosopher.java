/* Copyright 2010, Joseph Bergin
 * Creative Commons Attribution-Noncommercial 3.0 United States License
 */

/**
 * A class of objects that can perform the "Dining Philosophers" simulation.
 * 
 * @author Joseph Bergin
 * @version 1.0 (Greenfoot) January 2010
 */
public class Philosopher extends RunnableRobot
{
	/**
	 * Create a philosopher to be placed into the world and prepare it for threaded
	 * execution using its "run" method.
	 */
	public Philosopher(Direction direction)
	{
		super(direction);
	}
	
	public Philosopher(int street, int avenue, Direction direction, int beepers){
	    super(street, avenue, direction, beepers);
	}

	/** Add four philosophers to the world and the "forks" they will use. */
	public static void populate()
	{
		KarelWorld world = KarelWorld.itself();
		KarelWorld.initializeThreads();
		world.readWorld("worlds", "philosopher.kwld");
		Philosopher p1 = new Philosopher(2,3,NORTH,0);
		p1.setColor("red");
		Philosopher p2 = new Philosopher(3,2,EAST,0);
		p2.setColor("green");
		Philosopher p3 = new Philosopher(4,3,SOUTH,0);
		p3.setColor("blue");
		Philosopher p4 = new Philosopher(3,4,WEST,0);
	}

	/**
	 * This is the method used by the thread system. It will be invoked automatically.
	 */
	public void run()
	{
		while (true)
		{
			think(d.roll());
			getForks();
			eat(d.roll());
			putForks();
		}
	}

	/** Philosopher backs away from the table to think. */
	private void think(int time)
	{
		for (int i = 0; i < time; ++i)
		{
			backUp();
			move();
		}
	}

	/** Philosopher moves in to the table to eat. */
	private void eat(int time)
	{ // userPause("eat");
		for (int i = 0; i < time; ++i)
		{
			move();
			backUp();
		}
	}

	/**
	 * Philosopher picks up a fork from its left and one from its right, but waits until
	 * they are available.
	 */
	private void getForks()
	{
		turnLeft();
		move();
		while (!anyBeepersInBeeperBag())
		{
			while (!nextToABeeper())
				; // nothing
			pickBeeper();
		}
		turnAround();
		move();
		putBeeper();
		move();
		while (!anyBeepersInBeeperBag())
		{
			while (!nextToABeeper())
				; // nothing
			pickBeeper();
		}
		turnAround();
		move();
		putBeeper();
		turnRight();
		// showState("Eat ");
	}

	/**
	 * Philosopher puts down both of its forks, one to the left and one to the right.
	 */
	private void putForks()
	{
		pickBeeper();
		pickBeeper();
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		move();
		putBeeper();
		turnAround();
		move();
		turnRight();
		// showState("Think ");
	}
	

	private Die d = new Die(6);
}
