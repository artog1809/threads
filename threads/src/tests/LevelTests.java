package tests;

import main.model.Ball;
import main.model.Level;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LevelTests {

    @Test
    public void buildBallTestingOnSizes(){
        Level level = new Level();
        Ball ball = level.buildBall();
        int expectedWidth = 500;
        int expectedHeight = 500;
        Assert.assertEquals(expectedHeight, ball.getHeight());
        Assert.assertEquals(expectedWidth, ball.getWidth());

    }

    @Test
    public void buildBallTestingOnCountKnotsAndThreads(){
        Level level = new Level();
        Ball ball = level.buildBall();
        int expectedKnotsCount = 10;
        int expectedThreadsCount = 20;
        Assert.assertEquals(expectedKnotsCount, ball.getKnots().size());
        Assert.assertEquals(expectedThreadsCount, ball.getThreads().size());
    }
}
