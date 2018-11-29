
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class EnemyFly extends Mover {
   private int walkRange;
   private int xMin;
   private int xMax;
   private boolean firstAct;
   private int speed;
   private String direction = "left";  
   private int status;
   private int walkStatus = 1;
    
  public EnemyFly() {
        super();
        setImage("slimeWalk1.png");
        getImage().mirrorHorizontally();
        walkRange = 230;
        firstAct = true;
        speed = 3;
    }
   public void switchFly()
   {
   if (status == 2){     
   if (walkStatus > 2){
           walkStatus = 1;
    }
   setImage("flyFly" + walkStatus + ".png");
   walkStatus ++;
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
        switchFly();
   }
  public void mirror(){
       if (direction.equals("right")){
       getImage().mirrorHorizontally();
    }  
  }
}
