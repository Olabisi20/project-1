package model;

public class AngryState implements State {

    @Override
    public void doAction(GameFigure gf) {
        if (gf instanceof Dragon) {
            Dragon dragon = (Dragon) gf;
            dragon.turnAngry();
            if (!dragon.isHit) {
                dragon.health--;
                dragon.isHit = true;
            }
            System.out.println(dragon.health);
        }
    }

}
