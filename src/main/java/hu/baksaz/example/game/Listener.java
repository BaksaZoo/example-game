package hu.baksaz.example.game;

@FunctionalInterface
public interface Listener<T extends Event> {
  void handleEvent(T event);
}
