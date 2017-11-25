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
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (shooter.x >0)
                shooter.translate(-5, 0);
                break;
            case KeyEvent.VK_RIGHT:
                if (shooter.x < Width)
                shooter.translate(5, 0);
                break;
            case KeyEvent.VK_UP:
                if (shooter.y > 0)
                shooter.translate(0, -5);
                break;
            case KeyEvent.VK_DOWN:
                if (shooter.y < Height)
                shooter.translate(0, 5);
                break;
        }
    
    }
}
