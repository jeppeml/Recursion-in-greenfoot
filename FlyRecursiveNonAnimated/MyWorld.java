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
        super(900, 400, 1); 
        Fly fly = new Fly();
        addObject(fly, 450, 20);
        haveChildren(fly, 220, 50, 3);
    }

    private void haveChildren(Fly mother, int spacingX, int spacingY, int stopChild){
        if(stopChild>0){
            // Fly get 3 children
            Fly flyChild1 = new Fly();
            addObject(flyChild1, mother.getX()-spacingX, mother.getY()+spacingY);
            haveChildren(flyChild1, spacingX/2, spacingY, stopChild-1);

            Fly flyChild2 = new Fly();
            addObject(flyChild2, mother.getX(), mother.getY()+spacingY);
            haveChildren(flyChild2, spacingX/2, spacingY, stopChild-1);

            Fly flyChild3 = new Fly();
            addObject(flyChild3, mother.getX()+spacingX, mother.getY()+spacingY);
            haveChildren(flyChild3, spacingX/2, spacingY, stopChild-1);
        }
    }
}
