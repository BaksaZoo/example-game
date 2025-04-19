package hu.baksaz.example.engine;

import java.awt.*;

@FunctionalInterface
public interface Listener<T extends AWTEvent> {
  void handleEvent(T event);
}
