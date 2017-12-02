
package model;

import controller.Main;

public class UFOAppearState implements State {

    @Override
    public void doAction(GameFigure gf) {
        FlyingSaucer fs = (FlyingSaucer) gf;
            if (fs.direction > 0) {
            // moving to the right
            fs.x += fs.UNIT_TRAVEL;
                if (fs.x + fs.WIDTH > Main.WIN_WIDTH) {
                fs.direction = -1;
                }
            } 
            else {
            // moving to the left
            fs.x -= fs.UNIT_TRAVEL;
                if (fs.x <= 0) {
                fs.direction = 1;
                }
            }
    }
    
}
