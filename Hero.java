
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private int width;
    int x = 596;
    int y = 3035;
    private boolean isOnGround;
    private int walkStatus;
    private int status = 0;
    private String direction = "right";   
    private int setPlaynumber = 1;
    private int springNumy;
    private int playerNum = 1;
    private int walkL = -10;
    private int walkR = 10;
    public static int diamanten;
    public static int sterren;
   public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p" + setPlaynumber + ".png");
    }
   @Override
     public void act() {
      handleInput();
      atWorldEdge();
      velocityX *= drag;
      velocityY += acc;
      if (velocityY > gravity) {
            velocityY = gravity;
        }
   applyVelocity();
for (Actor enemy : getIntersectingObjects(Enemy.class)) {
      if (enemy != null) {
             Greenfoot.setWorld(new MyWorld());
             break;
         }
      }
      for (Tile tile : getIntersectingObjects(Tile.class)){
      if(tile!= null){
          if(tile.getImage().toString().contains("hud_p1Alt")){
                 setPlaynumber = 1;
                 getWorld().removeObject(tile);
                 break;
         }else if(tile.getImage().toString().contains("hud_p2Alt")){
                 setPlaynumber = 2;
                 getWorld().removeObject(tile);
                 break;
         }else if(tile.getImage().toString().contains("hud_p3Alt")){
                 setPlaynumber = 3;
                 getWorld().removeObject(tile);
                 break;
         }else if(tile.getImage().toString().contains("star")){
            getWorld().removeObject(tile);
      }else         if(tile!= null){
            if(tile.getImage().toString().contains("liquid") && !tile.getImage().toString().contains("Top")){
                setLocation(x, y);
                setPlaynumber = 2;
                Greenfoot.setWorld(new MyWorld());
                break;            
            }
      }
       Actor diamand = getOneIntersectingObject(Diamand.class);
      {
          if(diamand != null)
          {
                World myWorld = getWorld();
                getWorld().removeObject(diamand);
                diamanten++;
                MyWorld world = getWorldOfType(MyWorld.class);
                if(world!= null) {
                    world.getScoreboard().addDiamanten();
              }
          }
      }
      Actor star = getOneIntersectingObject(Star.class);
      {
          if(star != null)
          {
                World myWorlds = getWorld();
                getWorld().removeObject(star);
                sterren++;
                MyWorld world = getWorldOfType(MyWorld.class);
                if(world!= null) {
                    world.getScoreboardStar().addStars();
              }
          }
      }
}
}}
private double posToNeg(double x) {
     return (x - (x * 2));
 }  
public void handleInput() {
    //gekregen van Gijs de Lange en zelf iets veranderd.
    if(setPlaynumber == 1){
      getImage().scale(82, 97);
      springNumy = -14;
      walkL = -10;
      walkR = 10;
      }else if(setPlaynumber == 2){
      getImage().scale(82, 120);
      springNumy = -17;
      walkL = -10;
      walkR = 10;
      }else if(setPlaynumber == 3){
      getImage().scale(56, 64);
      springNumy = -11;
      walkL = -7;
      walkR = 7;
    }
      width = getImage().getWidth() / 2;
      Tile tile = (Tile) getOneObjectAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class);
    if (tile == null) {
          tile = (Tile) getOneObjectAtOffset(this.width - 3, getImage().getHeight() / 2 + 1, Tile.class);
    }
    if (tile == null) {
          tile = (Tile) getOneObjectAtOffset((int) posToNeg(this.width) + 3, getImage().getHeight() / 2 + 1, Tile.class);
    }
    if (tile != null && tile.isSolid) {
         isOnGround = true;
     } else {
         isOnGround = false;
    }
    if (Greenfoot.isKeyDown("space")) {
        if (isOnGround) {
            velocityY = springNumy;
            animationJump(getWidth(), getHeight(), setPlaynumber);
        }
    }
    if (Greenfoot.isKeyDown("a")) {
          velocityX = walkL;
          direction = "left";
          animationWalk(getWidth(), getHeight(), setPlaynumber);
     } else if (Greenfoot.isKeyDown("d")) {
          velocityX = walkR;
          direction = "right";
          animationWalk(getWidth(), getHeight(), setPlaynumber);
     } else {
          animationStand(getWidth(), getHeight(), setPlaynumber);
    }
    }
public void animationWalk(int width, int heigth, int player) {
     if (status == 2) {
         if (walkStatus >= 11) {
              walkStatus = 1;
         }
         if (isOnGround) {
              setImage("p" + player + "_walk"
              + walkStatus + ".png");
          } else {
              setImage("p" + player + "_jump.png");
         }
         mirror();
         walkStatus++;
         status = 0;
          } else {
              status++;
     }
     getImage().scale(width, heigth);
    }
    public void animationJump(int width, int heigth, int player) {
        setImage("p" + player + "_jump.png");
        mirror();
        getImage().scale(width, heigth);
    }
    public void animationStand(int width, int heigth, int player) {
        if (isOnGround) {
            setImage("p" + player + "_walk1.png");
            getImage().scale(width, heigth);
            walkStatus = 1;
        } else {
            setImage("p" + player + "_jump.png");
        }
        mirror();
        getImage().scale(width, heigth);
    }
    public void mirror() {
        if (direction.equals("left")) {

            getImage().mirrorHorizontally();

        }
    }public int getWidth() {
        return getImage().getWidth();
    }
    public int getHeight() {
        return getImage().getHeight();
    }
}

