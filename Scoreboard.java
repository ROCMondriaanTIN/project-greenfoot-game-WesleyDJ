import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    
    public int aantalDiamanten = 0;
    
    public Scoreboard(){
        setImage(new GreenfootImage("X  " + aantalDiamanten, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    
    public void addDiamanten()
    {
       aantalDiamanten++; 
       setImage(new GreenfootImage("X  " + aantalDiamanten, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
    }    
}
