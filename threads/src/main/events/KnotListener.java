package main.events;

import java.util.EventListener;

public interface KnotListener extends EventListener {
    void knotMoved(KnotEvent e);
    void knotReleased(KnotEvent e);
}
