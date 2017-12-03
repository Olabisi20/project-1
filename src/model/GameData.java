package model;

import controller.Main;
import view.GamePanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.Timer;
import javax.swing.Timer;

public class GameData {
    public Score scoreBoard;
    private final int RADIUS = 6;
    public final  List<GameFigure> enemyFigures;
    public final List<GameFigure> friendFigures;
    public List<GameFigure> removeFriendFigures;
    public List<GameFigure> removeEnemyFigures;
    public Color [] color;
    public static Shooter shooter;
    public Menu menu;
//    public HealthLevel bar;
    private int tick = 0;
    private Random rand = new Random();
    public Timer addEnemyTimer;
    private ActionListener perform;

    public GameData() {
        enemyFigures = new CopyOnWriteArrayList<>();
        friendFigures = new CopyOnWriteArrayList<>();
        removeFriendFigures = new CopyOnWriteArrayList<>();
        removeEnemyFigures = new CopyOnWriteArrayList<>();
        menu= new Menu();
//        bar= new HealthLevel();
        scoreBoard = new Score();
        //timer = new Timer(1000, perform);
        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.
        shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 80);
        shooter.addObserver(scoreBoard);
        friendFigures.add(shooter);
        
       // friendFigures.add(cannon);

      
      //enemyFigures.add(new FlyingSaucer(50, 60));
        //enemyFigures.add(new FlyingSaucer(400, 20));
        addEnemyTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick++;
                System.out.println("tick: " + tick);
                
                if (tick % 5 == 1) {
                    int rx = rand.nextInt(Main.WIN_WIDTH);
                    int ry2= rand.nextInt(Main.WIN_HEIGHT);
                    enemyFigures.add(new Bomb(rx, ry2, 10, Color.PINK));
                } else if (tick % 7 == 1) {
                    int rx = rand.nextInt(Main.WIN_WIDTH);
                    int ry2= rand.nextInt(Main.WIN_HEIGHT);
                    enemyFigures.add(new FlyingSaucer(rx, ry2));
                } else if (tick % 10 == 1) {
                    int rx = rand.nextInt(Main.WIN_WIDTH);
                    int r2y = rand.nextInt(Main.WIN_HEIGHT);
                    enemyFigures.add(new Dragon(rx, r2y));
                    tick = 0;
                    
                }
                
            }
        });
    }
    
    public void addDragon() {
        System.out.println("add dragon");
        enemyFigures.add(new Dragon(100, 100));
    }
    
  //  public void addEnemy() {
//        int rx = rand.nextInt(Main.WIN_WIDTH);
//        int ry = rand.nextInt(Main.WIN_HEIGHT - 300);
//        int ry2= rand.nextInt(Main.WIN_HEIGHT-100);
//        enemyFigures.add(new Dragon(rx, ry2));
//        enemyFigures.add(new FlyingSaucer(rx, ry2));
//            enemyFigures.add(new Bomb(
//     (int) (Math.random() * GamePanel.width),
//     (int) (Math.random() * GamePanel.height), 10,
//      Color.PINK));
//    }
    
    public void addEnemy() {

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



    public void update() {
        GameFigure f;
        
        
        
        enemyFigures.removeAll(removeEnemyFigures);
        
        for (GameFigure g : enemyFigures) {
            g.update();
        }

        
        friendFigures.removeAll(removeFriendFigures);

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

