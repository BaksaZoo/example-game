package hu.baksaz.example.game;

import hu.baksaz.example.engine.ApplicationContext;
import hu.baksaz.example.engine.Game;
import hu.baksaz.example.engine.InputEvent;

public class Main {
  public static void main(String[] args) {
    Game game = new Game();

    ApplicationContext.getPublisher().subscribe(InputEvent.class, event -> {
      if (event.getKey() == 'q') {
        game.stopGame();
      }
    });

    game.startGame();
  }
}