package tests;
import main.model.Ball;
import main.model.DistanceKnot;
import main.model.Knot;
import main.model.Level;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class DistanceKnotTest {

   Level level = new Level();

    Ball ball = level.buildBall();


    @Test
    public void moveTest(){
        DistanceKnot actual = new DistanceKnot(new Point(1,1), ball);
        actual.move(new Point(2,2));
        Point expected = new Point(2,2);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void distanceBareerTest(){
        ArrayList<Knot> knots = new ArrayList<>();
        DistanceKnot actual = new DistanceKnot(new Point(1,1), ball);
        DistanceKnot second = new DistanceKnot(new Point(4,4), ball);
        knots.add(actual);
        knots.add(second);
        ball.setKnots(knots);
        actual.move(new Point(3,3));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }
}
