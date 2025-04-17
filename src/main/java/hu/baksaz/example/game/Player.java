package hu.baksaz.example.game;

import hu.baksaz.example.engine.ApplicationContext;
import hu.baksaz.example.engine.Box2D;
import hu.baksaz.example.engine.InputEvent;
import java.util.StringJoiner;

public class Player {
  private Box2D player;

  public Player() {
    this.player = new Box2D()
      .setWidth(10)
      .setHeight(10)
      .setX(100)
      .setY(100);

    ApplicationContext.getPublisher().subscribe(InputEvent.class, this::handleInput);
  }

  private void handleInput(InputEvent inputEvent) {
    switch (Character.toLowerCase(inputEvent.getKey())) {
      case 'w' -> player.setY(player.getY() - 10);
      case 's' -> player.setY(player.getY() + 10);
      case 'a' -> player.setX(player.getX() - 10);
      case 'd' -> player.setX(player.getX() + 10);
    }
    System.out.println(player);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
      .add("player=" + player)
      .toString();
  }
}
