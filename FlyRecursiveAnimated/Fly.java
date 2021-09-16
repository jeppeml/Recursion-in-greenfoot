import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    private int targetX = 260;
    private int targetY = 300;
    private int acts;
    private FlyCounter flyCounter;
    
    
    
    public Fly(FlyCounter flyCounter){
        super();
        this.flyCounter = flyCounter;
        flyCounter.addOneFlyToAmountOfFlies();
    }
    
    public Fly(FlyCounter flyCounter, int targetX, int targetY){
        this(flyCounter);
        this.targetX = targetX;
        this.targetY = targetY;
    }
    
    
    
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        acts++;
        if(findDungHill()){
            replicateRapidly();
        }
    }
    
    public void replicateRapidly(){
        int randomSecs = Greenfoot.getRandomNumber(10)+5;
        if(acts%(30*randomSecs)==0){ // Every 5 secs. spawn 4 flies
            for(int i=0;i<4;i++){
                int randX = Greenfoot.getRandomNumber(100)-50+getX();
                int randY = Greenfoot.getRandomNumber(100)-50+getY();
                getWorld().addObject(new Fly(flyCounter, randX, randY), randX, randY);
            }
        }
    }
    
    private boolean findDungHill(){
        if(acts%2==0){
            turn(Greenfoot.getRandomNumber(90)-45);
            move(Greenfoot.getRandomNumber(5));
        }
        else{
            turnTowards(targetX, targetY);
            Greenfoot.getRandomNumber(5);
        }
        
        // If Fly reached its target destination
        if(Math.abs(targetX-getX())<8 && Math.abs(targetY-getY())<8)
            return true;
        else return false;
    }
}
