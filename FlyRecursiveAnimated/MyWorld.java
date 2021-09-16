import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Counter counter = new Counter("Amount of Flies: "); 
    FlyCounter flyCounter = new FlyCounter();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Dung(), 300, 300);
        addObject(new Fly(flyCounter), 300, 20);
        addObject(counter, 500, 20);
    }
    
    public void act(){
        counter.setValue(flyCounter.getNumberOfFlies());
    }
}
