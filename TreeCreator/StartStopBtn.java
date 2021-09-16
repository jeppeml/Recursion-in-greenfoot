import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startStopBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartStopBtn extends Actor
{
    MyWorld mw;
    public StartStopBtn(MyWorld mw){
        this.mw = mw;
    }
    /**
     * Act - do whatever the startStopBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            mw.startStopAnim();
        }
        // Add your action code here.
    }    
    
    public void setStarted(boolean s){
        if(s)
            this.setImage("images/button-green.png");
        else
            this.setImage("images/button-red.png");
    }
}
