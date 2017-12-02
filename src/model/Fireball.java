/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Fireball extends GameFigure {
    
    BufferedImage image;
    private int width;
    private int height;
    public Fireball(float x, float y) {
        super(x, y);
        try {
            image = ImageIO.read(getClass().getResource("Fireball.png"));
            image = resize(image, image.getWidth()/15, image.getHeight()/15);
            width = image.getWidth();
            height = image.getHeight();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open fireball.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int)x, (int)y, null);
//        g.draw(new Rectangle2D.Float(x, y, width, height));
    }

    @Override
    public void update() {
        super.y+=4;
        if (super.y > Main.WIN_HEIGHT + 50) {
            Main.gameData.removeFriendFigures.add(this);
        }
    }

    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(x, y, width, height);
    }
}
