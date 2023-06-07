package main.model;

import java.awt.*;

public class NotMovingKnot extends Knot{
    /**
     * @param position Позиция узла
     */
    public NotMovingKnot(Point position) {
        super(position);
    }

    @Override
    public void move(Point fixPos){
        fixPos = super.getPosition();
        setPosition(fixPos);
        fireKnotMoved();
    }
}
