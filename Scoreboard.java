import greenfoot.*;  

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
}
