package hu.baksaz.example.engine;

@FunctionalInterface
public interface Listener<T extends Event> {
  void handleEvent(T event);
}
