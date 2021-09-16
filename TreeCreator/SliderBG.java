import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SliderBG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SliderBG extends Actor
{
    
    public SliderBG(int width, int middle){
        GreenfootImage img = new GreenfootImage(width, middle*2);
        
        img.setColor(new Color(0,0,0));

        img.drawLine(0,middle,width,middle);
        this.setImage(img);
    }
    /**
     * Act - do whatever the SliderBG wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
