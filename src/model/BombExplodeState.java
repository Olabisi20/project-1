
package model;

public class BombExplodeState implements State {
private boolean exploding = false;
    @Override
    public void doAction(GameFigure gf) {
        Bomb b = (Bomb) gf;
            if(b.radius < 25){
            b.radius += 3;
            } else if (b.radius > 24) {
                b.setState(new DeathState());
                b.myState.doAction(b);
            }
            
            
        
    }
    
}
