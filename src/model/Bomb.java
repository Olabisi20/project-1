package model;

import view.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class Bomb extends GameFigure {


    public final Color color;
    public int radius;
    public int dx = 3;
    public int dy = 3;
    public boolean exploding = true;
  

    public Bomb(float x, float y, int radius, Color color) {
        super(x, y);
        myState = new BombAppearState();
        this.radius = radius;
        this.color = color;
      
    }
    
    @Override
    public void setState(State s) {
        myState = s;
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
        myState.doAction(this);
    }

    public void updateLocation() {
        x+= dx;
        y+=dy;
        //System.out.println("updating location");
       if (x + radius > GamePanel.width) {
            dx = -dx;
            x = GamePanel.width - radius;
        } 
       else if (x - radius < 0) {
        dx = -dx;
            x = radius;
        }
        if (y + radius > GamePanel.height) {
            dy = -dy;
            y = GamePanel.height - radius;
        } 
        else if (y - radius < 0) {
           dy = -dy;
           y = radius;
        }
             
    }
    

    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(x - radius, y - radius, radius * 2, radius * 2);
    }

    
}
