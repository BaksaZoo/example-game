package hu.baksaz.example.game;

import hu.baksaz.example.engine.ApplicationContext;
import hu.baksaz.example.engine.GameManager;
import hu.baksaz.example.engine.InputEvent;

public class Main {
  public static void main(String[] args) {
    GameManager gameManager = new GameManager();

    ApplicationContext.getPublisher().subscribe(InputEvent.class, event -> {
      if (event.getKey() == 'q') {
        gameManager.stopGame();
      }
    });

    gameManager.startGame();
  }
}