import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends Actor
{
    private int startX;
    private int endX;
    private MyWorld mw;
    
    public Slider(int startX, int endX, MyWorld mw){
        this.startX = startX;
        this.endX = endX;
        this.mw = mw;
        getImage().scale(30,30);
        
    }
    
    
    
    /**
     * Act - do whatever the Slider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            if(x<startX) x = startX;
            if(x>endX) x = endX;
            setLocation(x, this.getY());
            mw.update();
        }
    }    
}
