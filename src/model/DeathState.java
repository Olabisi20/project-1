
package model;

import controller.Main;

public class DeathState implements State{
    Shooter shoot= (Shooter)Main.gameData.friendFigures.get(0);
    @Override
    public void doAction(GameFigure gf) {
        Main.gameData.removeEnemyFigures.add(gf);
        Main.gameData.scoreBoard.score++;
    }
    
}
