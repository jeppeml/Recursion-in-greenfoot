/**
 * Write a description of class FlyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyCounter  
{
    private int amountOfFlies=0;
    
    public void addOneFlyToAmountOfFlies(){
        amountOfFlies++;
    }
    
    public int getNumberOfFlies(){
        return amountOfFlies;
    }
}
