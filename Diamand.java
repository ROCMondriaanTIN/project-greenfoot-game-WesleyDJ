import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamand extends Collectable
{
    public static int sID;
    private int id;
    
    public Diamand(){
        setImage("gemBlue.png");
        this.id = sID;
        sID++;
    }
    public void act() 
    {
        applyVelocity();
        
        for(Actor diamand : getIntersectingObjects(Diamand.class)) {
            if (diamand != null) {
                getWorld().removeObject(this);
                break;
            }
        }    
    }
}