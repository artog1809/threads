package tests;

import main.model.NotMovingKnot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
public class NotMovingKnotsTest {

    @Test
    public void moveOnXAndYTest(){
        NotMovingKnot actual = new NotMovingKnot(new Point(1,1));
        actual.move(new Point(2,2));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void moveOnXTest(){
        NotMovingKnot actual = new NotMovingKnot(new Point(1,1));
        actual.move(new Point(2,1));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void moveOnYTest(){
        NotMovingKnot actual = new NotMovingKnot(new Point(1,1));
        actual.move(new Point(1,2));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void notMoveTest(){
        NotMovingKnot actual = new NotMovingKnot(new Point(1,1));
        actual.move(new Point(1,1));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected,actual.getPosition());
    }

    @Test
    public void negativeCoordsMoveTest(){
        NotMovingKnot actual = new NotMovingKnot(new Point(-2,-7));
        actual.move(new Point(-7,-2));
        Point expected = new Point(-2,-7);
        Assert.assertEquals(expected,actual.getPosition());
    }
}
