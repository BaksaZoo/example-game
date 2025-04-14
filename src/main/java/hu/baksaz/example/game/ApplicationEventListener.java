package hu.baksaz.example.game;

public interface ApplicationEventListener<T extends Event> {
  void onApplicationEvent(T event);
}
