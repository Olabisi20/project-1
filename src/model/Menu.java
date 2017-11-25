
package model;

import controller.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
    
    public Rectangle playButton ;
     public Rectangle quitButton ;
     public int buttonWidth=100;
     public int buttonHeight=50;
     
     Menu(){
    playButton = new Rectangle(Main.WIN_WIDTH/2-(buttonWidth/2), Main.WIN_HEIGHT/4, buttonWidth,buttonHeight);
    quitButton = new Rectangle( Main.WIN_WIDTH/2-(buttonWidth/2), Main.WIN_HEIGHT/2, buttonWidth,buttonHeight); 
     
}

    public void render (Graphics g){
        if (!Main.animator.startGame){
        Graphics2D g2d = (Graphics2D) g;
        Font f = new Font("arial", Font.BOLD, 30);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("Are You Ready?", Main.WIN_WIDTH/3, 30);
        
        Font f1 = new Font("arial", Font.BOLD, 18);
        g.setFont(f);
        g.drawString("Play", Main.WIN_WIDTH/2-(buttonWidth/2)+20, Main.WIN_HEIGHT/4+40);
        g.drawString("Quit", Main.WIN_WIDTH/2-(buttonWidth/2)+20, Main.WIN_HEIGHT/2+40);
        g2d.draw(playButton);
        g2d.draw(quitButton);
        }
    }
}
