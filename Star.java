import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Collectable
{
    public static int sID;
    private int id;
    public Star(){
        setImage("star.png");
        this.id = sID;
        sID++;
    }
    public void act() 
    {
        applyVelocity();   
        for(Actor star : getIntersectingObjects(Star.class)) {
            if (star != null) {
                getWorld().removeObject(this);
                break;
            }
        }    
    }
}