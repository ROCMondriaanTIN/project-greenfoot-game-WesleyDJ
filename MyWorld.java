
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**1504
 *
 * @author R. Springer
 */
public abstract class MyWorld extends World {

    private CollisionEngine ce;
    private Scoreboard scoreboard;
    private ScoreboardStar scoreboardstar;
    private ScoreboardKey scoreboardkey;
    protected Hero hero;
    int[][] map;
    Camera camera;
    TileEngine te;
    public static boolean firstWorld = true;
    
    
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        if(firstWorld){
        scoreboardstar = new ScoreboardStar();
        scoreboard = new Scoreboard();
        scoreboardkey = new ScoreboardKey();
        Hero hero = new Hero(scoreboardstar,scoreboard,scoreboardkey);
        firstWorld = false;
        }
        this.setBackground("bg.png");      
    }
    public abstract void load();
    
    public void create(int level, int heroSpawnX, int heroSpawnY){
        te = new TileEngine(this, 70, 70, this.map);
        Camera camera = new Camera(te);
        hero.setSpawn(heroSpawnX, heroSpawnY);
        hero.setLevel(level);
        
        
       camera.follow(hero);
       ce = new CollisionEngine(te, camera);
       addObject(camera, 0, 0);
       addObject(hero, heroSpawnX, heroSpawnY);//map4 596, 3035
       addObject(new Diamant(), 900, 758);
       addObject(new StarHud(), 475, 20);
       addObject(new KeyHud(), 40, 758);
       addObject(scoreboardkey, 99, 760);
       addObject(scoreboardstar, 525, 23);
       addObject(scoreboard, 949, 760);
       camera.act();
       hero.act();
       ce.addCollidingMover(hero);


       
    }
     public Scoreboard getScoreboard() {
        return scoreboard;
    }
    public ScoreboardStar getScoreboardStar(){
        return scoreboardstar;
    }
    public ScoreboardKey scoreboardKey(){
        return scoreboardkey;
    }
   @Override
    public void act() {
        ce.update();
    }
}
