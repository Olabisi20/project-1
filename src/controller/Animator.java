package controller;

import static controller.Main.gameData;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.TimeUnit;
import model.GameData;
import model.GameFigureState;
import model.Shooter;

public class Animator implements Runnable {

    public boolean running = true;
    private final int FRAMES_PER_SECOND = 40;
    public boolean startGame = false;
    
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
      
          
        for(int i  = 0; i < Main.gameData.friendFigures.size(); i++){
            for(int j = 0; j < Main.gameData.enemyFigures.size(); j++){
                
        Rectangle2D.Float collideOne = (Rectangle2D.Float) Main.gameData.friendFigures.get(i).getCollisionBox();
        Rectangle2D.Float collideTwo= (Rectangle2D.Float) Main.gameData.enemyFigures.get(j).getCollisionBox();

                if(collideOne.intersects(collideTwo)){ 
 //                  shoot.addScore();
   //                System.out.print("hit");
                    Main.gameData.friendFigures.get(i).declareState();
                    Main.gameData.enemyFigures.get(j).declareState();    
                }
            }
        }
    }

}
