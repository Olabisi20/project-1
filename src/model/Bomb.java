package model;

import view.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class Bomb extends GameFigure {


    private final Color color;
    private int radius;
    private int dx = 3;
    private int dy = 3;
    private boolean exploding = true;
  

    public Bomb(float x, float y, int radius, Color color) {
        super(x, y);
        super.state = GameFigureState.BOMB_STATE_ADDED;
        this.radius = radius;
        this.color = color;
      
    }
    
    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        // Note: use drawOval() to draw outline only
        g.fillOval((int)(x - radius), (int)(y - radius), 
                radius * 2, radius * 2);
    }

    @Override
    public void update() {
        // ball bounces on the wall
        
        if(state == GameFigureState.BOMB_STATE_ADDED){
            super.x += dx;
            super.y += dy;

            if (super.x + radius > GamePanel.width) {
                dx = -dx;
                super.x = GamePanel.width - radius;
            } 
            else if (super.x - radius < 0) {
                dx = -dx;
                super.x = radius;
            }

            if (super.y + radius > GamePanel.height) {
                dy = -dy;
                super.y = GamePanel.height - radius;
            } 
            else if (super.y - radius < 0) {
                dy = -dy;
                super.y = radius;
            }
        }
        else if(state == GameFigureState.BOMB_STATE_EXPLODE){
           
            if(exploding == true){
                if(radius < 25){
                radius += 3;
                }
                else{
                    exploding = false;
                }
            }
            else if(exploding == false){
                if (radius >= 0){
                    radius -= 2;
                    if (radius <= 0){
                        state = GameFigureState.STATE_DONE;
                    }
                }    
            }

        }
        

    }

    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(x - radius, y - radius, radius * 2, radius * 2);
    }

    
}
