package model;

import java.awt.Graphics2D;

public class GameFigureState {
 public float x;
    public float y;
    public int state;
    

    
    /* common to all game figures */
    public static final int STATE_DONE = 0;
    public static final int STATE_SAFE=1;
    public  static final int STATE_DANGER = 2;
    /* missile states */
    public static final int MISSILE_STATE_LAUNCHED = 1;
    public static final int MISSILE_STATE_EXPLODED = 2;
    
    

    /* ufo states */
    public static final int UFO_STATE_APPEARED = 10;
    public static final int UFO_STATE_DAMAGED = 11; // not implemented yet
    
    // dragon states
    public static final int DRAGON_STATE_APPEAR=12;
    public static final int DRAGON_STATE_REDUCING=13;
    public static final int DRAGON_STATE_DISAPPEAR=14;

    /* bomb states */
    public static final int BOMB_STATE_ADDED = 20;
    public static final int BOMB_STATE_EXPLODE=21;
    /* shooter states */
    public static final int SHOOTER_STATE_HEALTH_LEVEL_5 = 30;
    public static final int SHOOTER_STATE_HEALTH_LEVEL_4 = 31; // not implemented yet
    public static final int SHOOTER_STATE_HEALTH_LEVEL_3 = 32; // not implemented yet
    public static final int SHOOTER_STATE_HEALTH_LEVEL_2 = 33; // not implemented yet
    public static final int SHOOTER_STATE_HEALTH_LEVEL_1 = 34; // not implemented yet
 
  
}
