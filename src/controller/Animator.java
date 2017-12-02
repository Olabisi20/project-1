package controller;

import static controller.Main.gameData;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.TimeUnit;
import model.DragonAngryState;
import model.Bomb;
import model.BombExplodeState;
import model.Dragon;
import model.FlyingSaucer;
import model.GameData;
import model.GameFigure;
import model.GameFigureState;
import model.HealthLevel;
import model.Missile;
import model.Score;
import model.Shooter;
import model.ShooterAppearState;
import model.ShooterDamageState;
import model.UFODamageState;

public class Animator implements Runnable {
    Score score;
    public boolean running = true;
    private final int FRAMES_PER_SECOND = 40;
    public boolean startGame = false;
    HealthLevel level;
    
    @Override
    public void run() {

        while (running) {
            long startTime = System.currentTimeMillis();
            
            processCollisions();
            if (startGame){
             Main.gameData.update();   
            }

           // Main.gameData.update();
            Main.gamePanel.gameRender();
            Main.gamePanel.printScreen();

            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
            }
        }
        System.exit(0);
    }
    
    private void processCollisions() {
        // detect collisions between friendFigure and enemyFigures
        // if detected, mark it as STATE_DONE, so that
        // they can be removed at update() method
       Shooter shoot= (Shooter)Main.gameData.friendFigures.get(0);
       
//       for (GameFigure ef : Main.gameData.enemyFigures) {
//           if (ef.getCollisionBox().intersects(shoot.getCollisionBox())) {
//               if (!shoot.isHit) {
//                Main.gameData.loseHealth();
//                shoot.isHit = true;
//               }
//           }
//       }
       
       for (GameFigure ff : Main.gameData.friendFigures) {
           for (GameFigure ef : Main.gameData.enemyFigures) {
//               if (ff instanceof Shooter) {
//                   Shooter shooter = (Shooter) ff;
//                    shooter.setState(new ShooterDamageState());
//                }
                    
               
               
              
               
               if (ff.getCollisionBox().intersects(ef.getCollisionBox())) {
                   if (ef instanceof Dragon) {
                       Dragon dragon = (Dragon) ef;
                       dragon.setState(new DragonAngryState());
                       dragon.myState.doAction(dragon);
                       dragon.isHit = false;
                       
                   }
                   
                   if (ef instanceof FlyingSaucer) {
                       FlyingSaucer fs = (FlyingSaucer) ef;
                       ef.setState(new UFODamageState());
                   }
               
                   if (ef instanceof Bomb) {
                       Bomb b = (Bomb) ef;
                       b.setState(new BombExplodeState());
                   }
                   
                  if (ef instanceof Dragon){
                       Dragon d = (Dragon) ef;
                       if ( ff instanceof Shooter){
                           Shooter s = (Shooter) ff;
                           if (d.getCollisionBox().intersects(s.getCollisionBox()));
                          
                          Main.gameData.bar.healthCount--;
                          s.setState(new ShooterAppearState());
                  }
////                   }
//                   if (ff instanceof Missile) {
//                       Missile m = (Missile) ff;
//                       Main.gameData.removeFriendFigures.add(m);
//                   }
                   
               }
           }
       }
       }}} 
    


