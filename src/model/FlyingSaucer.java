package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.GamePanel;

public class FlyingSaucer extends GameFigure {

    private final int WIDTH = 50;
    private final int HEIGHT = 20;
    private final int UNIT_TRAVEL = 5; // per frame
    private Image image;

    private int direction = 1; // +1: to the right; -1 to the left

    public FlyingSaucer(float x, float y) {
        super(x, y); // origin: upper-left corner
        super.state = GameFigureState.UFO_STATE_APPEARED;

        image = null;

        try {
            image = ImageIO.read(getClass().getResource("ufo.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x , (int) super.y,
                WIDTH, HEIGHT, null);
    }

    @Override
    public void update() {
        if(state == GameFigureState.UFO_STATE_APPEARED){
            
            if (direction > 0) {
            // moving to the right
            super.x += UNIT_TRAVEL;
                if (super.x + WIDTH > GamePanel.width) {
                direction = -1;
                }
            } 
            else {
            // moving to the left
            super.x -= UNIT_TRAVEL;
                if (super.x <= 0) {
                direction = 1;
                }
            }
        }
        else if (state == GameFigureState.UFO_STATE_DAMAGED){
          
          if(super.y - 5.0F > -6.0F){
              
              y += 5;
            }
           if(super.y >= GamePanel.height - HEIGHT ){
                state = GameFigureState.STATE_DONE;
                //System.out.print("flying saucer is done");
            }
        }
    }
     @Override
    public void declareState() {
        state = GameFigureState.UFO_STATE_DAMAGED;
    }
 public Rectangle2D getCollisionBox(){
        return new Rectangle2D.Float(x - (float)WIDTH/2, y - (float)HEIGHT/2, (float)WIDTH, (float)HEIGHT);
    }

   
 
}
