package main.model;

import java.awt.*;

public class HorizontalMovingKnot extends Knot{

    /**
     * @param position Позиция узла
     */
    public HorizontalMovingKnot(Point position) {
        super(position);
    }
    @Override
    public void move(Point newPosition){
        newPosition.y = super.getPosition().y;
        setPosition(newPosition);
        fireKnotMoved();
    }
}
