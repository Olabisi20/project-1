
package model;

import controller.Main;

public class DeathState implements State{

    @Override
    public void doAction(GameFigure gf) {
        Main.gameData.removeEnemyFigures.add(gf);
        Main.gameData.scoreBoard.score++;
        Main.gameData.shooter.isHit = false;
    }
    
}
