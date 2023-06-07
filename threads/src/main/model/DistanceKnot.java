package main.model;

import java.awt.*;
import java.util.ArrayList;

public class DistanceKnot extends Knot{

    private int distance = 3;
    public Ball ball;

    /**
     * @param position Позиция узла
     */
    public DistanceKnot(Point position, Ball b) {
        super(position);
        this.ball = b;
    }

    @Override
    public void move(Point newPosition){
        ArrayList<Knot> knots = ball.getKnots();
        System.out.print("print1\n");
        double closestKnotDistance = 100000.0;

        for (Knot knot : knots) {
            if (knot instanceof DistanceKnot && !this.equals(knot)) {

                Point knotPosition = new Point(knot.getPosition().x, knot.getPosition().y);
                double currentClosestD = Math.sqrt(Math.pow(Math.abs(knotPosition.x - newPosition.x),2) + Math.pow(Math.abs(knotPosition.y - newPosition.y),2));
                System.out.println("для текущего высчитано " + currentClosestD);
                System.out.println("это кратчайшее " + closestKnotDistance);
                if (currentClosestD <= closestKnotDistance){
                    closestKnotDistance = currentClosestD;
                }

            }
        }

        System.out.println("distance zadano " + distance);

        if(closestKnotDistance > distance){
            System.out.print("пытаемся двигаться\n");
            super.setPosition(newPosition);
            fireKnotMoved();
//            System.out.println("newPos " + newPosition.x);
//            newPosition.x = super.getPosition().x;
//            System.out.println("sup " + super.getPosition().x);
//
//            newPosition.y = super.getPosition().y;
//            setPosition(newPosition);
//            fireKnotMoved();
        }



    }
}
