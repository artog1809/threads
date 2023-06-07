package tests;

import main.model.Knot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class KnotsTest {

    @Test
    public void constructorTest(){
        Knot actual = new Knot(new Point(1,1));
        Point expected = new Point(1,1);
        Assert.assertEquals(expected, actual.getPosition());
    }

    @Test
    public void moveTest(){
        Knot actual = new Knot(new Point(1,1));
        actual.move(new Point(2,2));
        Point expected = new Point(2,2);
        Assert.assertEquals(expected,actual.getPosition());
    }
}
