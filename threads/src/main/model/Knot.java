package main.model;

import main.events.KnotEvent;
import main.events.KnotListener;

import java.awt.*;
import java.util.ArrayList;

public class Knot {

    private Point position;

    public static Object image;

    public Point getPosition(){
        return this.position;
    }

    /**
     *
     * @param position Позиция узла
     */
    public Knot(Point position){
        this.position = position;
    }

    /**
     *
     * @param newPosition Новая позиция узла, после передвижения
     */
    public void move(Point newPosition){
        this.position = newPosition;
            fireKnotMoved();
    }

    protected void setPosition(Point pos){
        this.position.y = pos.y;
        this.position.x = pos.x;
    }

    // ----------------Порождает события--------------------

    private ArrayList knotListener =  new ArrayList();

    /**
     *
     * Присоединяет слушателя
     */
    public void addKnotListener(KnotListener l){ knotListener.add(l);}

    /**
     *
     * Отсоединяет слушателя
     */
    public void removeKnotListener(KnotListener l){
        knotListener.remove(l);
    }

    /**
     *
     * Оповещает слушателей о событии
     */
    public void fireKnotMoved(){
        KnotEvent event = new KnotEvent(this);

        for (Object listener : knotListener){
            ((KnotListener)listener).knotMoved(event);
        }
    }

    public void fireKnotReleased(){
        KnotEvent event = new KnotEvent(this);

        for (Object listener : knotListener){
            ((KnotListener)listener).knotReleased(event);
        }
    }


    /**
     *
     * Перегрузка оператора
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Knot other = (Knot) obj;
        if ((this.position == null) ? (other.position != null) : !this.position.equals(other.position)) {
            return false;
        }
        return true;
    }
}
