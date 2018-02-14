import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LostMineMiner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LostMineMiner extends Robot
{
    /**
     * Act - do whatever the LostMineMiner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean leftIsClear;
    
    public void act() 
    {


        step1();
        
    } 
    
    public LostMineMiner()
    {
        super(1, 1, EAST, 0);
        populate(); // You can populate the world here rather than making a separate
        // call.
    }
    
    public static void populate()
    {
        KarelWorld world = KarelWorld.itself();
        world.readWorld("worlds", "lostbeepermine.kwld");
    }
    
    public void step1()
    {
        turnToNorth();
        move();
        if(frontIsClear()){
        step1();
        
       
          
        } else {
        
           
           turnToEast();
            
           while(frontIsClear())
           move();
           
           step2();
        
        }
        
    }
    
    public void step2(){
    
        if(howManyBeepers() == 1){
        
            turnToNorth();

        
        } else if(howManyBeepers() == 2){
            
            turnToWest();

        
        } else if(howManyBeepers() == 3){
        
        
            turnToSouth();

        }else if(howManyBeepers() == 4){
        
            turnToEast();
                
        
        } else if(howManyBeepers() == 5){
            turnToNorth();
            
            step3();
        
        
        }
        move();
        step2();
    }
    
    public void step3(){
        
        

 
        if(!frontIsClear()){
            
            while(!frontIsClear())
            turnLeft();
            step4(leftIsClear(),0);
            
            
            
        } else {
           
            move();  


        }
            step3();

    }
    
    
    public void step4(boolean leftClear, int count){
        
        

        if(leftClear && frontIsClear()){
            
                move();
           step4(leftClear,count);

        
        } else if (!leftClear && count < 10) {
        
           move();
           step4(leftClear,++count);
            

        
        }
        
        turnRight();
        step5();

            
    
    
    }
    
    public void step5(){
      
        move();
        
        if(!frontIsClear()){
        
            turnToEast();
            step6(0);
            
        
        }
        

        step5();
    
    
    
    }
    
    public void step6(int count){
    
        
        
        
        if (nextToABeeper()){
            
            turnToNorth();
            for(int i = 0; i < count / 2; i ++){
            
                move();
            
            }
            
            turnToEast();
            
            while(frontIsClear())
            move();
            goHome();
            
            step1();
            

        
        
        }
        
        move();
        step6(++count);
        
        
    
    
    
    
    }
    
    public void goHome(){
        
        
        while(checkIfHome() == false){
        turnToSouth();
        while(frontIsClear())
        move();
        turnToWest();
        while(frontIsClear())
        move();
    }
    
    
        
    }
    
    public boolean checkIfHome(){
                turnToSouth();
                boolean southClear = frontIsClear();
                turnToWest();
                boolean northClear = frontIsClear();    
                
                return !southClear && !northClear;
    }
    

    
    
    public void turnToEast(){
    
        while(!facingEast()){
        
            turnLeft();
        
        }
        
    }
     public void turnToWest(){
    
        while(!facingWest()){
        
            turnLeft();
        
        }
        
    }   
      public void turnToNorth(){
    
        while(!facingNorth()){
        
            turnLeft();
        
        }
        
    }  
     public void turnToSouth(){
    
        while(!facingSouth()){
        
            turnLeft();
        
        }
        
    }   
    
    public boolean leftIsClear(){
           
        

        int count = 0;
           while(!facingWest()){

            turnLeft();
            count ++;
        
        }
        
        for(int i = 0; i < count; i ++){
        
            turnRight();
        
        }

        if(frontIsClear()){
        
            return true;
        }
            
        return false;
    
    }
    
    public void turnRight(){
    
            for(int i = 0; i < 3; i ++){
        
            turnLeft();
        
        }
    
    }
    

    //Returns the number of beepers the robot is on. returns 0 if it has infinite amount
    public int howManyBeepers(){
        
        //Check for infinite Beepers
        Beeper beeper = (Beeper)getOneIntersectingObject(Beeper.class);
        if(beeper == null){
        
            return -1;
        }
        return beeper.howMany();
    }
    
    
    
    
    
}
