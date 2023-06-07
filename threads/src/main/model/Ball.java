package main.model;

import java.util.ArrayList;

public class Ball {

    private int width;
    private int height;

    /**
     * Список узлов
     */
    private ArrayList<Knot> knots = new ArrayList<>();

    /**
     * Список нитей
     */
    private ArrayList<Thread> threads = new ArrayList<>();

    public Ball(int width, int height){
        if(width <= 0) throw new IllegalArgumentException("Field width must be more than 0");
        if(height <= 0) throw new IllegalArgumentException("Field height must be more than 0");
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public void setKnots(ArrayList<Knot> knots){
        this.knots = knots;
    }
    public void setThreads(ArrayList<Thread> threads){
        this.threads = threads;
    }
    public ArrayList<Knot> getKnots(){
        return this.knots;
    }
    public ArrayList<Thread> getThreads(){
        return this.threads;
    }
    public void addKnot(Knot k){
        this.knots.add(k);
    }

    /**
     * Проверить, не осталось ли пересечений нитей
     * @return false - пересечений не осталось, true - остались пересечения
     */
    public boolean anyThreadsCrossing(){
        boolean threadsCrossing = false;
        for(int i = 0; i < threads.size(); i++){
            for(int j = i+1; j < threads.size(); j++){
                threadsCrossing = getThreads().get(i).checkTwoThreadsOnCrossing(getThreads().get(j));
                if(threadsCrossing)
                    return true;
            }
        }
        return false;
    }
}
