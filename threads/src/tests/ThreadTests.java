package tests;

import main.model.Knot;
import main.model.Thread;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertThrows;

public class ThreadTests {

    @Test
    public void constructorTest(){
        Knot knot1 = new Knot(new Point(1,1));
        Knot knot2 = new Knot(new Point(2,2));
        Thread actual = new Thread(knot1,knot2);

        Knot expKnot1 = new Knot(new Point(1,1));
        Knot expKnot2 = new Knot(new Point(2,2));

        Assert.assertEquals(expKnot1, actual.getBegin());
        Assert.assertEquals(expKnot2, actual.getEnd());
    }

    @Test
    public void checkingEquationOfLinesWithPositiveNumbers(){
        Knot knot1 = new Knot(new Point(2,3));
        Knot knot2 = new Knot(new Point(6,4));
        double k;
        double b;
        Thread thread = new Thread(knot1,knot2);
        thread.getEquationOfStraight();
        k = thread.getK();
        b = thread.getB();
        double expk = 0.25;
        double expb = 2.5;
        Assert.assertEquals(expk,k, 0.0);
        Assert.assertEquals(expb,b, 0.0);
    }

    @Test
    public void checkingEquationOfLinesWithNegativeNumbers(){
        Knot knot1 = new Knot(new Point(-2,3));
        Knot knot2 = new Knot(new Point(6,-4));
        double k;
        double b;
        Thread thread = new Thread(knot1,knot2);
        thread.getEquationOfStraight();
        k = thread.getK();
        b = thread.getB();
        double expk = -0.875;
        double expb = 1.25;
        Assert.assertEquals(expk,k, 0.0);
        Assert.assertEquals(expb,b, 0.0);
    }

    @Test
    public void checkingEquationOfLinesWithZeroes(){
        Knot knot1 = new Knot(new Point(0,3));
        Knot knot2 = new Knot(new Point(1,0));
        double k;
        double b;
        Thread thread = new Thread(knot1,knot2);
        thread.getEquationOfStraight();
        k = thread.getK();
        b = thread.getB();
        double expk = -3;
        double expb = 3;
        Assert.assertEquals(expk,k, 0.0);
        Assert.assertEquals(expb,b, 0.0);
    }

    @Test
    public void checkingEquationOfLinesWithSimilarCoordinates(){
        Knot knot1 = new Knot(new Point(0,0));
        Knot knot2 = new Knot(new Point(0,0));
        Thread thread = new Thread(knot1,knot2);

        assertThrows(IllegalArgumentException.class, () -> thread.getEquationOfStraight());
    }

    @Test
    public void twoThreadsCrossingTest(){
        Knot knot1 = new Knot(new Point(1,1));
        Knot knot2 = new Knot(new Point(3,3));
        Knot knot3 = new Knot(new Point(2,3));
        Knot knot4 = new Knot(new Point(4,2));

        Thread thread1 = new Thread(knot1,knot2);
        Thread thread2 = new Thread(knot3,knot4);

        Assert.assertTrue(thread1.checkTwoThreadsOnCrossing(thread2));
    }

    @Test
    public void twoThreadsNotCrossingTest(){
        Knot knot1 = new Knot(new Point(1,1));
        Knot knot2 = new Knot(new Point(3,3));
        Knot knot3 = new Knot(new Point(6,2));
        Knot knot4 = new Knot(new Point(10,6));

        Thread thread1 = new Thread(knot1,knot2);
        Thread thread2 = new Thread(knot3,knot4);

        Assert.assertFalse(thread1.checkTwoThreadsOnCrossing(thread2));
    }

    @Test
    public void twoThreadsNotCrossingWithNegativeNumbersTest(){
        Knot knot1 = new Knot(new Point(1,1));
        Knot knot2 = new Knot(new Point(3,3));
        Knot knot3 = new Knot(new Point(-2,-3));
        Knot knot4 = new Knot(new Point(-4,-8));

        Thread thread1 = new Thread(knot1,knot2);
        Thread thread2 = new Thread(knot3,knot4);


        Assert.assertFalse(thread1.checkTwoThreadsOnCrossing(thread2));
    }

    @Test
    public void twoThreadsCrossingWithNegativeNumbersTest(){
        Knot knot1 = new Knot(new Point(-6,-2));
        Knot knot2 = new Knot(new Point(4,-10));
        Knot knot3 = new Knot(new Point(-2,-3));
        Knot knot4 = new Knot(new Point(-4,-8));

        Thread thread1 = new Thread(knot1,knot2);
        Thread thread2 = new Thread(knot3,knot4);

        Assert.assertTrue(thread1.checkTwoThreadsOnCrossing(thread2));
    }


}
