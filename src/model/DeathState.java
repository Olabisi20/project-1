/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;

/**
 *
 * @author Olabisi
 */
public class DeathState implements State{
    Shooter shoot= (Shooter)Main.gameData.friendFigures.get(0);
    @Override
    public void doAction(GameFigure gf) {
        Main.gameData.removeEnemyFigures.add(gf);
    }
    
}
