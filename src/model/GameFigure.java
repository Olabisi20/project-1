package model;

import java.awt.Graphics2D;
//import java.awt.event.ActionListener;
//import java.util.Random;
//import javax.swing.Timer;

public abstract class GameFigure implements CollisionBox {
      
    // public for a faster access during animation
    public float x;
    public float y;
    public State st;
    public int state;
    public int time;
   // Random r = new Random();
   // Timer timer;

    public GameFigure(float x, float y) {
        this.x = x;
        this.y = y;
      
    }
    
   
public  void generateEnenmy(){
    
    
}

    // how to render on the canvas
    public abstract void render(Graphics2D g);

    public abstract void declareState();
    // changes per frame
    public abstract void update();

}
