package hu.baksaz.example.engine;

import java.awt.*;

public class Event extends AWTEvent {
  public Event(Object source) {
    super(source, 0);
  }
}
