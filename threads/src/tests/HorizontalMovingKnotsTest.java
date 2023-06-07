package tests;

import main.model.HorizontalMovingKnot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
public class HorizontalMovingKnotsTest {

    @Test
    public void moveOnXAndYTest(){
        HorizontalMovingKnot actual = new HorizontalMovingKnot(new Point(1,1));
        actual.move(new Point(2,2));
        Point expected = new Point(2,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void moveOnXTest(){
        HorizontalMovingKnot actual = new HorizontalMovingKnot(new Point(1,1));
        actual.move(new Point(2,1));
        Point expected = new Point(2,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void moveOnYTest(){
        HorizontalMovingKnot actual = new HorizontalMovingKnot(new Point(1,1));
        actual.move(new Point(1,2));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void notMoveTest(){
        HorizontalMovingKnot actual = new HorizontalMovingKnot(new Point(1,1));
        actual.move(new Point(1,1));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void negativeCoordsMoveTest(){
        HorizontalMovingKnot actual = new HorizontalMovingKnot(new Point(-2,-7));
        actual.move(new Point(-7,-2));
        Point expected = new Point(-7,-7);
        Assert.assertEquals(expected,actual.getPosition());
    }
}
