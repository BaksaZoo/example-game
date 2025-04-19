package hu.baksaz.example.engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationEventPublisher {

  private final Map<Class<? extends AWTEvent>, List<Listener<? extends AWTEvent>>> listeners = new HashMap<>();

  public <T extends AWTEvent> void subscribe(Class<T> eventType, Listener<T> listener) {
    listeners.computeIfAbsent(eventType, k -> new ArrayList<>())
      .add(listener);
  }

  public <T extends AWTEvent> void publish(T event) {
    Class<?> eventClass = event.getClass();
    @SuppressWarnings("unchecked")
    List<Listener<T>> typedListeners = (List<Listener<T>>) (List<?>) listeners.getOrDefault(eventClass, List.of());
    typedListeners.forEach(listener -> listener.handleEvent(event));
  }

}
