
package model;

import controller.Main;

public class ShooterDamageState implements State {

    @Override
    public void doAction(GameFigure gf) {
        Shooter shooter = (Shooter) gf;
      
        
        
//        if (!shooter.isHit) {
//            shooter.isHit = true;
//           // Main.gameData.bar.healthCount--;
//            shooter.setState(new ShooterAppearState());
//        }
        
      if (Main.gameData.bar.healthCount < 1) {
          Main.animator.startGame = false;
      }
        
        
        
            if (shooter.x < 20) {
            if (shooter.y < 0) {
                shooter.dy = 0;
            } else if (shooter.y > Main.WIN_HEIGHT - 80) {
                shooter.dy = 0;
            }            
            shooter.dx = 0;
        } else if (shooter.x > Main.WIN_WIDTH - shooter.BASE_SIZE) {
            if (shooter.y < 0) {
                shooter.dy = 0;
            } else if (shooter.y > Main.WIN_HEIGHT - 80) {
                shooter.dy = 0;
            }
            shooter.dx = 0;
        } else if (shooter.y < 0) {
                shooter.dy = 0;
            } else if (shooter.y > Main.WIN_HEIGHT - 80) {
                shooter.dy = 0;
        }
          
        
        shooter.barrel.x1 += shooter.dx;
        shooter.barrel.x2 += shooter.dx;
        shooter.barrel.y1 += shooter.dy;
        shooter.barrel.y2 += shooter.dy;
        shooter.x = shooter.barrel.x1;
        shooter.y = shooter.barrel.y1;
        shooter.base.x += shooter.dx;
        shooter.base.y += shooter.dy;        
        
    }
    
}
