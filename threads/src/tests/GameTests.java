package tests;

import main.model.Ball;
import main.events.KnotEvent;
import main.events.KnotListener;
import main.model.Level;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

    private enum EVENT {KNOTMOVED}
    private ArrayList<EVENT> knots_events = new ArrayList<>();

    private class KnotObserver implements KnotListener{
        @Override
        public void knotMoved(KnotEvent e) {
            knots_events.add(EVENT.KNOTMOVED);
        }

        @Override
        public void knotReleased(KnotEvent e){}
    }

    @Test
    public  void knotEvent(){
        Level level = new Level();

        Ball ball = level.buildBall();

        for(var i: ball.getKnots()){
            i.addKnotListener(new KnotObserver());
        }

        ball.getKnots().get(0).move(new Point(4,4));
        assertTrue(!knots_events.isEmpty());
    }

}
