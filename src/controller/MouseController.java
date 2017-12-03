package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Missile;
import model.Shooter;

public class MouseController extends MouseAdapter {
    
    public int x;
    public int y;
    public int buttonWidth=Main.gameData.menu.buttonWidth;
    public int buttonHeight= Main.gameData.menu.buttonHeight;
    //public static int count=0;
    
    @Override
    public void mousePressed(MouseEvent me) {
        
        int x = me.getX();
        int y = me.getY();

         if (!Main.animator.startGame){
            if( x >Main.WIN_WIDTH/2-(buttonWidth/2)&& 
                    x < Main.WIN_WIDTH/2-(buttonWidth/2)+ buttonWidth &&
                    y>Main.WIN_HEIGHT/4 &&  y < Main.WIN_HEIGHT/4+ buttonHeight){
               // System.out.println("play button is pressed" +count);
           //     count++;
           Main.animator.startGame=true;
           Main.gameData.addEnemy();
           Main.gameData.shooter.healthBar.healthCount = 5;
           Main.gameData.enemyFigures.clear();
           Main.gameData.scoreBoard.score = 0;
           Main.gameData.addEnemyTimer.start();
           
            }
           if( x >Main.WIN_WIDTH/2-(buttonWidth/2)&& 
                    x < Main.WIN_WIDTH/2-(buttonWidth/2)+ buttonWidth &&
                    y>Main.WIN_HEIGHT/2 &&  y < Main.WIN_HEIGHT/2 + buttonHeight){
               // System.out.println("quit button is pressed" +count);
                System.exit(0);
             //   count++;
            } 
        }
        
        Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);

        Missile m = new Missile(
                shooter.getXofMissileShoot(),
                shooter.getYofMissileShoot(),
                x, y, // target location where the missile explodes
                Color.RED);

        Main.gameData.friendFigures.add(m.getMissile());

    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        /*if (!Main.animator.startGame){
            if( x >Main.WIN_WIDTH/2-(buttonWidth/2)&& 
                    x < Main.WIN_WIDTH/2-(buttonWidth/2)+ buttonWidth &&
                    y>Main.WIN_HEIGHT/4 &&  y < Main.WIN_HEIGHT/4+ buttonHeight){
                System.out.println("hovering over start button" +count);
                count++;
            }
           if( x >Main.WIN_WIDTH/2-(buttonWidth/2)&& 
                    x < Main.WIN_WIDTH/2-(buttonWidth/2)+ buttonWidth &&
                    y>Main.WIN_HEIGHT/2 &&  y < Main.WIN_HEIGHT/2 + buttonHeight){
                System.out.println("hovering over quit button" +count);
                count++;
            } 
        }*/
    }

}
