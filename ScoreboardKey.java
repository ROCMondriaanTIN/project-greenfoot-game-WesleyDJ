import greenfoot.*;  

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreboardKey extends Actor
{
    public int aantalKeys = 0;
    public ScoreboardKey(){
        setImage(new GreenfootImage("X  " + aantalKeys, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    public void addKeys()
    {
       aantalKeys++; 
       setImage(new GreenfootImage("X  " + aantalKeys, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    public void removeKeys()
    {
       aantalKeys = 0; 
       setImage(new GreenfootImage("X  " + aantalKeys, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
