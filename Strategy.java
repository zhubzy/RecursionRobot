/* Copyright 2010, Joseph Bergin
 * Creative Commons Attribution-Noncommercial 3.0 United States License
 */

/**
 * An interface to define Strategy objects for the Strategy design pattern.
 * 
 * @author Joseph Bergin
 * @version 1.0, January 2010
 */
public interface Strategy
{
	/**
	 * A robot will carry out the current strategy
	 * 
	 * @param which the robot to perform the strategy
	 */
	public void doIt(UrRobot which);
}
