package model;

import controller.Main;
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
    private BufferedImage angryImage;
    private BufferedImage resizeAngryImage;
    private BufferedImage resizeImage;
    private int width;
    private int height;
    private BufferedImage reduceImage;
    private int direction = -1; // +1: to the right; -1 to the left
    public State myState = new AliveState();
    public int health = 5;
    public boolean isHit = false;
    public boolean isAngry = false;
    
    public float dx;
    public float dy;
    Shooter shoot= (Shooter)Main.gameData.friendFigures.get(0);
    public Dragon (float x, float y) {
        super(x, y); // origin: upper-left corner
       // super.state = GameFigureState.DRAGON_STATE_APPEAR;

        image = null;

        try {
            image = ImageIO.read(getClass().getResource("dragon.png"));
            resizeImage = resize(image, image.getWidth()/6, image.getHeight()/6);
            width = resizeImage.getWidth();
            height = resizeImage.getHeight();
            
            angryImage = ImageIO.read(getClass().getResource("angry_dragon.png"));
            resizeAngryImage = resize(angryImage, angryImage.getWidth()/6, angryImage.getHeight()/6);
            
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open dragon.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(resizeImage, (int) super.x , (int) super.y, null);
    }
    
    public void turnAngry() {
        if (health < 5) {
            System.out.println("turn angry");
            resizeImage = resizeAngryImage;
            isAngry = true;
        }
    }

    @Override
    public void setState(State s) {
        myState = s;
    }
    
    @Override
    public void update() {
        if (health < 0) {
                setState(new DeathState());
                myState.doAction(this);
                shoot.isHit = false;
        }
        
        if (!isAngry) {

            if (direction > 0) {
                // vertically
                super.y += UNIT_TRAVEL;
                    if (super.y > GamePanel.height) {
                    direction = -1;
                    }
            } else {
            // moving vertically
            super.y -= UNIT_TRAVEL;
                if (super.y <= 0) {
                direction = 1;
                }
            }
        } else if (isAngry) { // go to the shooter
            Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
            double angle = Math.atan2(shooter.y - super.y, shooter.x - super.x);
            dx = (float) (UNIT_TRAVEL * Math.cos(angle));
            dy = (float) (UNIT_TRAVEL * Math.sin(angle));
            super.x += dx;
            super.y += dy;
            
            
        }
            
    }
    

 public Rectangle2D getCollisionBox(){
        return new Rectangle2D.Float(x, y, (int) width, (int) height);
    }

   
 
 
}

