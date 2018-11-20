
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
   private String direction = "left";  
   private int status;
   private int walkStatus = 1;

    
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
   if (status == 2){ 
    
       if (walkStatus > 2){
           walkStatus = 1;
        }
            setImage("slimeWalk" + walkStatus + ".png");
            walkStatus ++;
        
        
    
    /*
       if (getImage().equals  (slimew1))
        {
            setImage(slimew2);
        }
        else 
        {
            setImage(slimew1);
        }
        */
        status = 0;
   if (direction.equals("right")) {
       getImage().mirrorHorizontally();
   }
}else{
    status++;
}
  }
   @Override
    public void act() {
        int x = getX();
        int y = getY();
       
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
                direction = "left";
                
            } else if (getX() <= xMin) {
                speed *= -1;
                x = xMin;
                direction = "right";

            }
            
         switchSlime();
   }
   public void mirror(){
       if (direction.equals("right")){
       getImage().mirrorHorizontally();
    }  
    }
}
