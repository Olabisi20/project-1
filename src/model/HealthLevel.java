package model;
import controller.Main;
import java.awt.Color;
import java.awt.Graphics2D;


public class HealthLevel {
    public int healthSize;
    public int healthBarX;
    public int    healthBarY;

     public int   healthTextX;
      public int  healthTextY;

        // Size of health block
     public int   healthBarBlockW;
     public int   healthBarBlockH;

      public int  healthBarGap = 5;
      public int healthCount = 5;
      
HealthLevel(){
        healthBarX = 15;
        healthBarY = 15;

        healthTextX = 50;
        healthTextY = 50;

        // Size of health block
        healthBarBlockW = 15;
        healthBarBlockH = 50;

        healthBarGap = 5;
}
      
    public void render(Graphics2D g){
        g.setColor(Color.BLUE);
        if(Main.animator.startGame){
        for (int i = 0; i < healthCount; i++) {
            g.fillRect(healthBarX + ((healthBarBlockW + healthBarGap) * i) , healthBarY, healthBarBlockW, healthBarBlockH);
        }
        }
    }
}
