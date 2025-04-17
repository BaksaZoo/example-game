package hu.baksaz.example.game;

import java.io.IOException;

public class InputManager {

  public InputManager() {
    ApplicationContext.getPublisher().subscribe(GameTickEvent.class, this::handleEvent);
  }

  public void handleEvent(GameTickEvent event) {
    try {
      if (System.in.available() > 0) {
        char c = (char) System.in.read();
        ApplicationContext.getPublisher().publish(new InputEvent(c));
      }
    } catch (IOException e) {
      System.err.println("Error reading input: " + e.getMessage());
    }
  }
}
