

PROJECT TITLE: Karel J Robot   
PURPOSE OF PROJECT: To use the Karel J Robot ideas and book within Greenfoot. 
VERSION or DATE: 1.0 January 2010
HOW TO START THIS PROJECT: Just double click on the project.greenfoot file
AUTHORS: Joseph Bergin
USER INSTRUCTIONS: This is much like the original Karel J Robot as described in 
the book (http://www.cafepress.com/kareljrobot). There are a few differences. 

The main difference is that the world is bounded to the North and East whereas in the original
it was bounded only on the South and West. You can create a world larger than the standard
20 by 20 if you like. 

The KarelWorld coordinates are differnt from Greenfoot. Here (1, 1) represents the lower left corner of 
the world. Streets (the first coordinate) increase toward the north and avenues (second coordinate) increase
toward the east. Normally the upper left Greenfoot coordinate is (0, 0) and represent a vertically reflected
euclidean world. In Karel it is a bit different. 

There are a few more constructors for robots here, to aid in the usual Greenfoot drop object (shift click)
usage. 

---
Getting Started:
Right Click on ManyTasks at the lower right and select getBeeper(). A short simulation will run. If it goes 
fast, drag the speed slider to the left a ways and try again. The Reset button will erase things in the world.

Double click on ManyTasks to see the code for getBeepers (and another task). 

Click on UrRobot and then shift-Click in the world near a corner. You should see a robot facing east. Right-
click on the robot to see what it can do. Select one of them and it will perform the action. 

Double click on UrRobot to see all of the things it can do. 

Right click on StairSweeper and select populate() You should see a world of stairs (walls) and beepers. Click 
StairSweeper (single click) and then shift-click in the world at the base of the stairs (to their left). Then
press the Act button at the bottom of the window. The robot should climb the stairs, picking up
all of the beepers and then turnOff. 

Double Click on StairSweeper to see how it was built. The source is provided for this so you can modify it.

Click on Beepers. Then shift-click in the world near a corner to place a beeper. Similarly for HorizontalWall,
VerticalWall, and InfiniteBeepers. 

Double Click KarelWorld to see what it is capable of. Right click o the window title (karelWorld) near the
top of the window to do any of those things. 

---

There are no packages in Greenfoot, so everything is in the "default" package. 

To define an interface (as in Chapter 4 of the book). You need to play a trick. Create a 
new class from the Edit menu (that shows when the world is the frontmost window). You will
get a new edit window with a class template. Change the word "class" to "interface" in 
this window and fill in your abstract methods. When you compile it, it will be properly
saved as an interface. To implement this interface in another class you could either just type
the implements phrase into the edit window of that class or, alternatively select new Subclass...
from the right mouse popup of the interface icon in the lower right of the Greenfield main window. 

You may subclass any of the robot classes here in the usual way. The Beeper and Wall classes, however 
cannot be subclassed, nor can the KarelWorld class (they are final classes). 

Once you have the book for yourself and your students you can find teaching materials at

http://csis.pace.edu/~bergin/KarelJava2ed/Karel++JavaEdition.html

A complete set of world files (walls and beepers) for all of the figures and 
all of the exercises in the book is included in the project in folder "worlds"

To set up the world for a run, there are two options. You can use the drop object methods built in to
greenfoot, which is useful in simple cases. However, for a comples scenario you may want to open a 
world file and place some robots in starting positions. The drop object can get tedious if you intend 
many runs. In this case do the following. First create a subclass of some Robot class and give it static
method. I use public static void populate()...
Within this method, open any world file readWorld(...), and create any robots. You will also unclude
instructions to place any needed robots or you may require the user to manually place these robots on 
their corners in the world. See the supplied
Philosopher and StairSweeper for examples. Another possibility (Mostly for Chapter 2 of the book) is 
illustrated in the ManyTasks class. 

If you don't like the sound made when a robot acts, you can turn off sounds with a static method 
of the UrRobot class. (These are actually off by default, but you can turn them on.)