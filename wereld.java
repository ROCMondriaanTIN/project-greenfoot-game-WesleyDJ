import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wereld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wereld extends World
{

    /**
     * Constructor for objects of class wereld.
     * 
     */
    public static final WorldRegistry worldRegistry = new WorldRegistry();
    
    public wereld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false); 
        setLevels();
        worldRegistry.getLevel(1).load();
    }
   public void setLevels() {
        MyWorld.firstWorld = true;
        worldRegistry.registerLevel(1, new Level1());
        worldRegistry.registerLevel(2, new Level2());
        worldRegistry.registerLevel(3, new Level3());
        worldRegistry.registerLevel(4, new Level4());
        
    }
}
