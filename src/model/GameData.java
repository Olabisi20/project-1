package model;

import controller.Main;
import view.GamePanel;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Timer;

public class GameData {
    public Score scoreBoard;
    private final int RADIUS = 6;
    public final  List<GameFigure> enemyFigures;
    public final List<GameFigure> friendFigures;
    public Color [] color;
    public static Shooter shooter;
    public Menu menu;
    public HealthLevel bar;
    private int tick = 0;
    private Random rand = new Random();
    

    public GameData() {
        enemyFigures = new CopyOnWriteArrayList<>();
        friendFigures = new CopyOnWriteArrayList<>();
        menu= new Menu();
        bar= new HealthLevel();
        scoreBoard = new Score();
        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.
        shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 80);
        shooter.addObserver(scoreBoard);
        friendFigures.add(shooter);
         color= new Color[3];
      
      //enemyFigures.add(new FlyingSaucer(50, 60));
        //enemyFigures.add(new FlyingSaucer(400, 20));
    }
    
    public void addEnemy() {
        int rx = rand.nextInt(Main.WIN_WIDTH);
        int ry = rand.nextInt(Main.WIN_HEIGHT - 300);
        int r2y= rand.nextInt(Main.WIN_HEIGHT-100);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                tick++;
                if (tick == 5) {
                   // enemyFigures.add(new Dragon(rx, r2y));
                   enemyFigures.add(new Bomb(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height), 10,
                     Color.PINK));
                    //new Color(red, green, blue)));*/
                    enemyFigures.add(new FlyingSaucer(rx, ry));
                    int rx = rand.nextInt(Main.WIN_WIDTH);
                   enemyFigures.add(new Dragon(rx, r2y));
                   System.out.print("add Dragon");
                    tick = 0;
                    
                }
            }
        }, 0, 1000);
    }
    
    public void addBomb(int n) {
        for (int i = 0; i < n; i++) {
            float red = (float) Math.random();
            float green = (float) Math.random();
            float blue = (float) Math.random();
            // adjust if too dark since the background is black
            if (red < 0.5) {
                red += 0.2;
            }
            if (green < 0.5) {
                green += 0.2;
            }
            if (blue < 0.5) {
                blue += 0.2;
            }
            enemyFigures.add(new Bomb(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height),
                    RADIUS,
                    new Color(red, green, blue)));
        }
    }
public void addUFO(){
    
        enemyFigures.add(new FlyingSaucer((int)(Math.random()*GamePanel.width),
                (int)(Math.random()*GamePanel.height)));
    }
public void addDragon(){
        enemyFigures.add(new Dragon((int) (Math.random() * GamePanel.WIDTH),
        (int)(Math.random()* GamePanel.height)));
}
    public void update() {
        // no enemy is removed in the program
        // since collision detection is not implemented yet.
        // However, if collision detected, simply set
        // f.state = GameFigure.STATE_DONE
        ArrayList<GameFigure> removeEnemies = new ArrayList<>();
        GameFigure f;
        for (int i = 0; i < enemyFigures.size(); i++) {
            f = enemyFigures.get(i);
            if (f.state == GameFigureState.STATE_DONE) {
                removeEnemies.add(f);
                shooter.addScore();
            }
        }
        enemyFigures.removeAll(removeEnemies);

        for (GameFigure g : enemyFigures) {
            g.update();
        }
 
        // missiles are removed if explosion is done
        ArrayList<GameFigure> removeFriends = new ArrayList<>();
        for (int i = 0; i < friendFigures.size(); i++) {
            f = friendFigures.get(i);
            if (f.state == GameFigureState.STATE_DONE) {
                removeFriends.add(f);
            }
        }
        friendFigures.removeAll(removeFriends);

        for (GameFigure g : friendFigures) {
            g.update();
        }}
        
        public List<GameFigure> getFriends(){
        
        return friendFigures;
    }
    
    public List<GameFigure> getEnemies(){
        
        return enemyFigures;
    }
    }

