import greenfoot.*;  

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreboardStar extends Actor
{
    public int aantalSterren = 0;
    public ScoreboardStar(){
        setImage(new GreenfootImage("X  " + aantalSterren, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    public void addStars()
    {
       aantalSterren++; 
       setImage(new GreenfootImage("X  " + aantalSterren, 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
