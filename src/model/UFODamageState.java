
package model;

import controller.Main;

public class UFODamageState implements State {

    @Override
    public void doAction(GameFigure gf) {
        FlyingSaucer fs = (FlyingSaucer) gf;
        fs.y += 3;
        
        if (fs.y > Main.WIN_HEIGHT + 20) {
            fs.setState(new DeathState());
        }
    }
    
    
}
