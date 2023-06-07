package main.model;

import java.awt.*;
import java.util.ArrayList;

public class Level {

    /**
     * Размеры игрового поля
     */
    private static final int FIELD_HEIGHT = 500;
    private static final int FIELD_WIDTH = 500;

    protected int fieldHeight(){
        return FIELD_HEIGHT;
    };

    protected  int fieldWidth(){ return FIELD_WIDTH; };

    public Ball ball;

    /**
     * Создание начальной обстановки
     * @return начальная обстановка
     */
    public Ball buildBall(){
        ball = new Ball(fieldWidth(),fieldHeight());
        addKnots();
        addThreads();
        return ball;
    }

    /**
     * Заполнить список узлов
     * @return заполненный список узлов
     */
    private ArrayList<Knot> fillKnots(){
        ArrayList<Knot> knots = new ArrayList<>();
        Knot knot1 = new HorizontalMovingKnot(new Point(12,12));
        knots.add(knot1);
        Knot knot2 = new NotMovingKnot(new Point(8,10));
        knots.add(knot2);
        Knot knot3 = new Knot(new Point(12,0));
        knots.add(knot3);
        Knot knot4 = new Knot(new Point(20,4));
        knots.add(knot4);
        Knot knot5 = new Knot(new Point(22,12));
        knots.add(knot5);
        Knot knot6 = new Knot(new Point(16,18));
        knots.add(knot6);
        Knot knot7 = new Knot(new Point(12,20));
        knots.add(knot7);
        Knot knot8 = new Knot(new Point(4,16));
        knots.add(knot8);
        Knot knot9 = new Knot(new Point(2,12));
        knots.add(knot9);
        Knot knot10 = new Knot(new Point(2,8));
        knots.add(knot10);
        return knots;
    }

    /**
     * Заполнить список нитей
     * @return заполненный список нитей
     */
    private ArrayList<Thread> fillThreads(){
        ArrayList<Thread> threads = new ArrayList<>();
        Thread thread1 = new Thread(ball.getKnots().get(0),ball.getKnots().get(1));
        threads.add(thread1);
        Thread thread2 = new Thread(ball.getKnots().get(0),ball.getKnots().get(2));
        threads.add(thread2);
        Thread thread3 = new Thread(ball.getKnots().get(1),ball.getKnots().get(3));
        threads.add(thread3);
        Thread thread4 = new Thread(ball.getKnots().get(2),ball.getKnots().get(4));
        threads.add(thread4);
        Thread thread5 = new Thread(ball.getKnots().get(3),ball.getKnots().get(5));
        threads.add(thread5);
        Thread thread6 = new Thread(ball.getKnots().get(4),ball.getKnots().get(5));
        threads.add(thread6);
        Thread thread7 = new Thread(ball.getKnots().get(5),ball.getKnots().get(2));
        threads.add(thread7);
        Thread thread8 = new Thread(ball.getKnots().get(3),ball.getKnots().get(1));
        threads.add(thread8);
        Thread thread9 = new Thread(ball.getKnots().get(2),ball.getKnots().get(4));
        threads.add(thread9);
        Thread thread10 = new Thread(ball.getKnots().get(3),ball.getKnots().get(6));
        threads.add(thread10);
        Thread thread11 = new Thread(ball.getKnots().get(7),ball.getKnots().get(8));
        threads.add(thread11);
        Thread thread12 = new Thread(ball.getKnots().get(9),ball.getKnots().get(5));
        threads.add(thread12);
        Thread thread13 = new Thread(ball.getKnots().get(4),ball.getKnots().get(8));
        threads.add(thread13);
        Thread thread14 = new Thread(ball.getKnots().get(5),ball.getKnots().get(7));
        threads.add(thread14);
        Thread thread15 = new Thread(ball.getKnots().get(9),ball.getKnots().get(7));
        threads.add(thread15);
        Thread thread16 = new Thread(ball.getKnots().get(9),ball.getKnots().get(6));
        threads.add(thread16);
        Thread thread17 = new Thread(ball.getKnots().get(8),ball.getKnots().get(5));
        threads.add(thread17);
        Thread thread18 = new Thread(ball.getKnots().get(7),ball.getKnots().get(5));
        threads.add(thread18);
        Thread thread19 = new Thread(ball.getKnots().get(6),ball.getKnots().get(4));
        threads.add(thread19);
        Thread thread20 = new Thread(ball.getKnots().get(3),ball.getKnots().get(6));
        threads.add(thread20);

        return threads;
    }
    public void addKnots(){
        ball.setKnots(fillKnots());
    }
    public void addThreads(){
        ball.setThreads(fillThreads());
    }

}
