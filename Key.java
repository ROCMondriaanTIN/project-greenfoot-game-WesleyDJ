import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Collectable
{
    public static int sID;
    private int id;
    public Key(){
        setImage("star.png");
        this.id = sID;
        sID++;
    }
    public void act() 
    {
        applyVelocity();   
        for(Actor key : getIntersectingObjects(Key.class)) {
            if (key != null) {
                getWorld().removeObject(this);
                break;
            }
        }    
    }
}