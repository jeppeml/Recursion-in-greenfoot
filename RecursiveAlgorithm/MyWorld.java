import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 900, 1); 
        iterativeBalloons();
        recursiveBalloons(250, 450, 0, 90);
    }
    private void recursiveBalloons(double x, double y, double turn, int maxBalloons){
        double newX = x+Math.sin(turn)*10;
        double newY = y+Math.cos(turn)*10;
        
        addObject(new Balloon(), (int)newX, (int)newY);
        addObject(new Balloon(), (int)newX-20, (int)newY);
        addObject(new Balloon(), (int)newX+20, (int)newY);
        
        if(maxBalloons>0)
            recursiveBalloons(newX, newY, turn+Math.PI/45, maxBalloons-1);
    }
    
    private void iterativeBalloons(){
        double r = 150;
        int xStart = 900;
        int yStart = 450;
        for(double i = 0;i < 2*Math.PI;i+=Math.PI/15){ // Because radians
            int x = xStart + (int)(r * Math.sin(i));
            int y = yStart + (int)(r * Math.cos(i));
            addObject(new Balloon(), x,y);
        }
    }
}
