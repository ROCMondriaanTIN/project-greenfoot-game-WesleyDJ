
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage walkIm1;
    private GreenfootImage walkIm2;
    private GreenfootImage walkIm3;
    private GreenfootImage walkIm4;
    private GreenfootImage walkIm5;
    private GreenfootImage walkIm6;
    private GreenfootImage walkIm7;
    private GreenfootImage walkIm8;
    private GreenfootImage walkIm9;
    private GreenfootImage walkIm10;
    private GreenfootImage walkIm11;
    private int width;
    int x = 579;
    int y = 200;
    private boolean isOnGround;

    private int walkStatus;

    private int status = 0;

    private String direction = "right";   


    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        
        walkIm1 = new GreenfootImage("p3_walk1.png");
        walkIm2 = new GreenfootImage("p3_walk2.png");
        walkIm3 = new GreenfootImage("p3_walk3.png");
        walkIm4 = new GreenfootImage("p3_walk4.png");
        walkIm5= new GreenfootImage("p3_walk5.png");
        walkIm6 = new GreenfootImage("p3_walk6.png");
        walkIm7 = new GreenfootImage("p3_walk7.png");
        walkIm8 = new GreenfootImage("p3_walk8.png");
        walkIm9 = new GreenfootImage("p3_walk9.png");
        walkIm10 = new GreenfootImage("p3_walk10.png");
        walkIm11 = new GreenfootImage("p3_walk11.png");
        setImage("p3_stand.png");
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
                setLocation(x, y);
                break;
            }
        }
         for (Actor Coin : getIntersectingObjects(Coin.class)) {
            if (Coin != null) {
                setLocation(x, y);
                break;
            }
        }
    }
    private double posToNeg(double x) {

        return (x - (x * 2));

    }
        public void handleInput() {
        //gekregen van Gijs de Lange en zelf iets veranderd.
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
                velocityY = -17;
                animationJump(getWidth(), getHeight(), 3);
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -10;
            direction = "left";
            animationWalk(getWidth(), getHeight(), 3);
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 10;
            direction = "right";
            animationWalk(getWidth(), getHeight(), 3);
        } else {
            animationStand(getWidth(), getHeight(), 3);
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
    /*public int coinSwitch() {
        If
*/
}
