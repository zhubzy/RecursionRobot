/* Copyright 2010, Joseph Bergin
 * Creative Commons Attribution-Noncommercial 3.0 United States License
 */


/**
 * RunnableRobot provides helper methods for robots that run in threads.
 * 
 * @author Joseph Bergin 
 * @version 1.0 (Greenfoot) January 2010
 */
public abstract class RunnableRobot  extends AugmentedRobot implements Runnable
{
    /** Create an EAST facing robot with no beepers 
     * Runnable robots set themselves up for threads in the constructor
     */
    public RunnableRobot()
    {
        super();
        KarelWorld.setupThread(this); 
    }
    
    /** Create an EAST facing robot with a specified number of beepers
     * @param beepers the initial number of beepers in the beeper bag
     */
    public RunnableRobot(int beepers)
    {
        this(EAST, beepers);
    }


    /** Create a robot facing a given direction EAST, NORTH,
     * WEST, or SOUTH, with no beepers.
     * @param direction the initial direction of the robot
     */
    public RunnableRobot(Direction direction)
    {
       super(direction);    
       KarelWorld.setupThread(this);
    }
    
    /** Create a robot facing a given direction with a given number of beepers
     * in its beeper bag. If the number of beepers is negative it will be
     * interpreted as infinitely many beepers. You may also use the constant
     * KarelWorld.INFINITE for infinitely many beepers. 
     * <p>
     * Runnable robots set themselves up for threads in the constructor
     * @param direction the direction the robot will initially face
     * @param beepers the initial number of beepers in the beeper bag
     */
    public RunnableRobot(Direction direction, int beepers)
    {   
        super(direction, beepers);
        KarelWorld.setupThread(this);
    }

    /** Create a robot on a specific street and avenue, facing a given direction with a 
     * given number of beepers. 
     * Runnable robots set themselves up for threads in the constructor
     * @param street the street on which to place the robot
     * @param avenue the avenue on which to place the robot
     * @param direction the direction the robot will initially face
     * @param beepers the initial number of beepers in the beeper bag
     */
    public RunnableRobot(int street, int avenue, Direction direction, int beepers)
    {   
        super(street, avenue, direction, beepers);
        KarelWorld.setupThread(this);
    }
        
    /** Start the simulation (perform this only once) */
    public static final void startThreads()
    {
        KarelWorld.startThreads();
    }
    
    /** Pause the simulation */
    public static final void pauseThreads()
    {
        KarelWorld.pauseThreads();
    }
        
    /** Resume the simulation after pausing */
    public static final void resumeThreads()
    {
        KarelWorld.resumeThreads();
    }
    /** Does nothing. Use the thread system instead */
    public void act()
    {
        //nothing Actions are controlled by the threads using the run method
    }
        
    /** This is the method used by the thread system. It will be invoked
     * automatically. Override it in your own subclass to do something
     * useful
     */
    public void run()
    {   
        // Do something useful here
    }
    
    /** Print a short usage note to standard output. */
    public static String usage()
    {
        System.out.println();
        System.out.println( "To use a RunnableRobot do this:");
        System.out.println("First, execute the populate() method of the class to get the world with robots.");
        System.out.println("Next, execute start() to start the threads.");
        System.out.println("Then you can pause and resume execution with those methods.");
        
        return "See the output listing.";
    }
    
   
}
