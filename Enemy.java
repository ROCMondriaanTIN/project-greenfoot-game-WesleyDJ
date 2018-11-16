
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {
   private int walkRange;
   private int xMin;
   private int xMax;
   private boolean firstAct;
   private int speed;
   private GreenfootImage slimew1 = new GreenfootImage("slimeWalk1.png");
   private GreenfootImage slimew2 = new GreenfootImage("slimeWalk2.png");
   private String direction = "right";   

    
   public Enemy() {
        super();
        setImage("slimeWalk1.png");
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 3;
    }
   public void switchSlime()
   {
   if (getImage().equals  (slimew1))
        {
            setImage(slimew2);
            direction = "left";
        }
        else 
        {
            setImage(slimew1);
        }
   }
   @Override
    public void act() {
        int x = getX();
        int y = getY();
        switchSlime();
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            getImage().mirrorHorizontally();
        }
   }
}
