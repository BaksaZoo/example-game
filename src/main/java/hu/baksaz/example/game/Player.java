package hu.baksaz.example.game;

import hu.baksaz.example.engine.ApplicationContext;
import hu.baksaz.example.engine.Box2D;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.StringJoiner;

public class Player {
  private Box2D playerSprite;

  public Player() {
    this.playerSprite = new Box2D()
      .setWidth(10)
      .setHeight(10)
      .setX(100)
      .setY(100)
      .setColor(Color.RED);
    this.playerSprite.onClick(e -> playerSprite.setColor(Color.GREEN));

    ApplicationContext.getPublisher().subscribe(KeyEvent.class, this::handleInput);
  }

  private void handleInput(KeyEvent keyEvent) {
    switch (Character.toLowerCase(keyEvent.getKeyChar())) {
      case 'w' -> playerSprite.setY(playerSprite.getY() - 10);
      case 's' -> playerSprite.setY(playerSprite.getY() + 10);
      case 'a' -> playerSprite.setX(playerSprite.getX() - 10);
      case 'd' -> playerSprite.setX(playerSprite.getX() + 10);
    }
    System.out.println(playerSprite);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
      .add("player=" + playerSprite)
      .toString();
  }
}
