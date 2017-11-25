package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Shooter;

public class KeyController extends KeyAdapter {
        public int x;
        public int y;
        public int Width=Main.WIN_WIDTH;
        public int Height= Main.WIN_HEIGHT;
    
    @Override
    public void keyPressed(KeyEvent e) {
        Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
        
        
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            Main.gameData.addDragon();
        }
        
        if (code == KeyEvent.VK_LEFT) {
            if (shooter.x > Main.WIN_WIDTH - 20) {
                shooter.x = Main.WIN_WIDTH - 21;
            }
            shooter.dx = -5;
        } else if (code == KeyEvent.VK_RIGHT) {
            if (shooter.x < 20) 
            {
                shooter.x = 21;
            }
            shooter.dx = 5;
        } else if (code == KeyEvent.VK_UP) {
            if (shooter.y > Main.WIN_HEIGHT - 80) {
                shooter.y = Main.WIN_HEIGHT - 81;
            }
            shooter.dy = -5;
        } else if (code == KeyEvent.VK_DOWN) {
            if (shooter.y < 0) {
                shooter.y = 1;
            }
            shooter.dy = 5;
        }
    }
}
