/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.GamePanel;


public class BombAppearState implements State {

    @Override
    public void doAction(GameFigure gf) {
        Bomb b = (Bomb) gf;
        b.updateLocation();
//       // b.y++;
//       if (b.x + b.radius > GamePanel.width) {
//            b.dx = -b.dx;
//            b.x = GamePanel.width - b.radius;
//        } 
//       else if (b.x - b.radius < 0) {
//        b.dx = -b.dx;
//            b.x = b.radius;
//        }
//        if (b.y + b.radius > GamePanel.height) {
//            b.dy = -b.dy;
//            b.y = GamePanel.height - b.radius;
//        } 
//        else if (b.y - b.radius < 0) {
//           b.dy = -b.dy;
//           b.y = b.radius;
//        }
        }
}
