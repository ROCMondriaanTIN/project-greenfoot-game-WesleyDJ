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
    public wereld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false); 
        Level1 level1 = new Level1();
        level1.load();
    }
}
