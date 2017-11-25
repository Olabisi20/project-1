package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.GamePanel;

public class Dragon extends GameFigure{
    
    private final int WIDTH = 60;
    private final int HEIGHT = 30;
    private final int UNIT_TRAVEL = 2; // per frame
    private BufferedImage image;
    private int width;
    private int height;
    private BufferedImage reduceImage;
    private int direction = -1; // +1: to the right; -1 to the left
    public State st= new AliveState();
    
    public Dragon (float x, float y) {
        super(x, y); // origin: upper-left corner
       // super.state = GameFigureState.DRAGON_STATE_APPEAR;

        image = null;

        try {
            image = ImageIO.read(getClass().getResource("dragon.png"));
            width = image.getWidth();
            height = image.getHeight();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open dragon.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x , (int) super.y,
                WIDTH, HEIGHT, null);
        
    }
    
  /*  public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dimg.createGraphics();
        g.drawImage(tmp, 0, 0, null);
        g.dispose();
        return dimg;    
    }*/

    @Override
    public void update() {
        
    /*    if (state == GameFigureState.DRAGON_STATE_REDUCING) {
            reduceImage = resize(image, width/ 3, height / 3);
            image = reduceImage;
        }*/
        
       if(true ){
             //   ||state == GameFigureState.DRAGON_STATE_REDUCING){
           
            if (direction > 0) {
            // vertically
            super.y += UNIT_TRAVEL;
                if (super.y > GamePanel.height) {
                direction = -1;
                }
            } 
            else {
            // moving vertically
            super.y -= UNIT_TRAVEL;
                if (super.y <= 0) {
                direction = 1;
                }
            }
        }
        if (state == GameFigureState.DRAGON_STATE_REDUCING){
          
            if(super.y - 5.0F > -6.0F){
            
           // reduceImage = resize(image, width/ 3, height / 3);
           // image = reduceImage;
        }
                if(super.y <= GamePanel.height - HEIGHT ){
                state = GameFigureState.STATE_DONE;
            }
        }
    }
     @Override
    public void declareState() {
        state = GameFigureState.DRAGON_STATE_REDUCING;
    }
 public Rectangle2D getCollisionBox(){
        return new Rectangle2D.Float(x - (float)WIDTH/2, y - (float)HEIGHT/2, (float)WIDTH, (float)HEIGHT);
    }

   
 
 
}

