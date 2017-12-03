package model;

import controller.Main;

public class DragonAngryState implements State {

    @Override
    public void doAction(GameFigure gf) {
        if (gf instanceof Dragon) {
            Dragon dragon = (Dragon) gf;
            dragon.turnAngry();
            if (!dragon.isHit) {
                dragon.health--;
                dragon.isHit = true;
            }
            
            if (dragon.health <= 0) {
                Main.gameData.shooter.isHit = false;
                dragon.setState(new DeathState());
            }
        }
    }

}
