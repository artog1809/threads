package main.model;

import java.awt.*;

public class Thread {
    private Knot knot_begin;
    private Knot knot_end;

    /**
     *
     * @param knot1 Координаты начального узла
     * @param knot2 Координаты конечного узла
     */
    public Thread(Knot knot1, Knot knot2){
        knot_begin = knot1;
        knot_end = knot2;
    }

    public Knot getBegin(){
        return knot_begin;
    }

    public Knot getEnd(){
        return knot_end;
    }

    /**
     * Коэффициенты уравнения прямой
     */
    private double k;

    private double b;

    public double getB() {
        return b;
    }

    public double getK() {
        return k;
    }

    public void getEquationOfStraight(){
        if (knot_begin.getPosition().y == knot_end.getPosition().y && knot_begin.getPosition().x == knot_end.getPosition().x) {
            throw new IllegalArgumentException("It's a point not a straight");
        }
        this.k = ((double) (knot_begin.getPosition().y - knot_end.getPosition().y)) /((double) (knot_begin.getPosition().x-knot_end.getPosition().x));
        this.b = (double) (-(k*knot_begin.getPosition().x) + knot_begin.getPosition().y);
    }

    /**
     *
     * @param thread Нить для проверки на пересечение
     * @return true - прямые пересекаются, false - не пересекаются
     */
    public boolean checkTwoThreadsOnCrossing(Thread thread){
        Point a = this.getBegin().getPosition();
        Point b = this.getEnd().getPosition();
        Point c = thread.getBegin().getPosition();
        Point d = thread.getEnd().getPosition();

        float det = (b.x - a.x) * (d.y - c.y) - (d.x - c.x) * (b.y - a.y);
        if (det == 0)
            return false;
        float lambda = ((d.y - c.y) * (d.x - a.x) + (c.x - d.x) * (d.y - a.y)) / det;
        float gamma = ((a.y - b.y) * (d.x - a.x) + (b.x - a.x) * (d.y - a.y)) / det;
        return (0 < lambda && lambda < 1) && (0 < gamma && gamma < 1);
    }
}
