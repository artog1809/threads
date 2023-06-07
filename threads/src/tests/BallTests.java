package tests;

import main.model.Ball;
import main.model.Knot;
import main.model.Level;
import main.model.Thread;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class BallTests {

    // Неверный параметр ширины передан в конструктор
    @Test
    public void constructorTestingBadWidth()
    {
        assertThrows(IllegalArgumentException.class, () -> new Ball(0, 10));
    }

    // Неверный параметр высоты передан в конструктор
    @Test
    public void constructorTestingBadHeight()
    {
        assertThrows(IllegalArgumentException.class, () -> new Ball(10, 0));
    }

    @Test
    public void constructorTestingGood(){
        Ball actual = new Ball(10,10);
        int expectedWidth = 10;
        int expectedHeight = 10;
        Assert.assertEquals(expectedHeight, actual.getHeight());
        Assert.assertEquals(expectedWidth, actual.getWidth());
    }

    @Test
    public void threadsNotCrossing(){
        Knot knot1 = new Knot(new Point(1,1));
        Knot knot2 = new Knot(new Point(3,3));
        Knot knot3 = new Knot(new Point(6,2));
        Knot knot4 = new Knot(new Point(10,6));
        Knot knot5 = new Knot(new Point(-2,-4));
        Knot knot6 = new Knot(new Point(-4,-2));


        Thread thread1 = new Thread(knot1,knot2);
        Thread thread2 = new Thread(knot3,knot4);
        Thread thread3 = new Thread(knot5,knot6);
        Thread thread4 = new Thread(knot1,knot3);


        ArrayList<Thread> threads= new ArrayList<>();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);

        Ball ball = new Ball(10,10);
        ball.setThreads(threads);
        Assert.assertFalse(ball.anyThreadsCrossing());
    }

    @Test
    public void threadsCrossing(){
        Level level = new Level();
        level.buildBall();
        Assert.assertTrue(level.ball.anyThreadsCrossing());
    }


}
