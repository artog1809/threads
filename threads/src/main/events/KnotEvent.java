package main.events;

import main.model.Knot;

import java.util.EventObject;

public class KnotEvent extends EventObject {

    private Knot knot;
    public KnotEvent(Object source) {
        super(source);
    }

    public void setKnot(Knot knot) { this.knot = knot; }

    public Knot knot(){ return this.knot; }
}
