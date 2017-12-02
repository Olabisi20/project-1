package model;

import controller.Main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import view.MainWindow;

public class Shooter extends GameFigure implements CollisionBox {
    
    Line2D.Float barrel;
    Rectangle2D.Float base;
    public final int BARREL_LEN = 20;
    public final int BASE_SIZE = 20;
    public List<Observer> observers= new ArrayList<>(); 
    public int score = 0;
  //  public HealthLevel level;
        
    public int dx;
    public int dy;
    public boolean isHit = false;
    
    public Shooter(int x, int y) {
        super(x, y);
        myState = new ShooterAppearState();
        barrel = new Line2D.Float(super.x, super.y, super.x, super.y-BARREL_LEN);
        base = new Rectangle2D.Float(super.x - BASE_SIZE /2 , super.y - BASE_SIZE / 2,
                BASE_SIZE, BASE_SIZE);
    }
    
    public void addObserver(Observer o){
        observers.add(o);
    }
    
    public void addScore(){
        score++;
        notifyAllObserver();
    }
    
    public void notifyAllObserver(){
        for(Observer o: observers){
            o.update(score);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.YELLOW);
        int tx = MainWindow.mouseController.x;
        int ty = MainWindow.mouseController.y;
        double rad = Math.atan2(ty - super.y, tx - super.x);
        int bendy = (int)(BARREL_LEN * Math.sin(rad));
        int bendx = (int)(BARREL_LEN * Math.cos(rad));
        barrel.x1 = super.x;
        barrel.y1 = super.y;
        barrel.x2 = super.x + bendx;
        barrel.y2 = super.y + bendy;
        g.setStroke(new BasicStroke(7)); // thickness of the line
        g.draw(barrel);
        g.draw(base);
    }
    
    public void ultimate() {
        for (int i = 0; i < 7; ++i) {
            Main.gameData.friendFigures.add(new Fireball(100 * i, -20*(i)));
        }
    }
    
    @Override
    public void setState(State s) {
        myState = s;
    }

    @Override
    public void update() {
        myState.doAction(this);
    }

//    public void translate(int dx, int dy) {
//        barrel.x1 += dx;
//        barrel.x2 += dx;
//        barrel.y1 += dy;
//        barrel.y2 += dy;
//        super.x = barrel.x1;
//        super.y = barrel.y1;
//        base.x += dx;
//        base.y += dy;
//    }
    
    // Missile shoot location: adjut x and y to the image
    public float getXofMissileShoot() {
        return barrel.x2;
    }
    
    public float getYofMissileShoot() {
        return barrel.y2;
    }
    public void declareState() {
      //healthCount--;
    } 

    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(base.x, base.y, 20, 20);
    }

   
}
