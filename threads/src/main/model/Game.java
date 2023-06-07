package main.model;

import main.events.KnotEvent;
import main.events.KnotListener;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Game {
    private Level level;

    private Ball ball;

    public Game(Level level){
        this.level = level;
        initGame();
    }

    /**
     * Постоить поле и обстановку на нем
     */

    private void build(){
        ball = level.buildBall();
    }

    /**
     * Начать игру
     */
    public void initGame(){
        build();
        for(var i: ball.getKnots()){
            i.addKnotListener(new KnotObserver());
        }
    }

    /**
     * Проверить закончилась ли игра
     * @return результат проверки
     */
    public boolean finishGame(){
        return !ball.anyThreadsCrossing();
    }


    /**
     * События
     */
    private class KnotObserver implements KnotListener {
        @Override
        public void knotMoved(KnotEvent e) {

        }

        @Override
        public void knotReleased(KnotEvent e){
            if(finishGame()){
                showMessageDialog(null, "Узлы распутаны", "Игра окончена", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/knot.png")));
            }
        }
    }
}
