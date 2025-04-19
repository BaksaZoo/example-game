package hu.baksaz.example.game;

import hu.baksaz.example.engine.ApplicationContext;
import hu.baksaz.example.engine.Box2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameMap {
  private List<Box2D> tektons;

  public GameMap() {
    int width = ApplicationContext.getWindowManager().getWidth();
    int height = ApplicationContext.getWindowManager().getHeight();
    int borderThickness = 10;
    this.tektons = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Box2D box2D = new Box2D()
          .setWidth(width / 3 - borderThickness * 2)
          .setHeight(height / 3 - borderThickness * 2)
          .setX(i * (width / 3) + borderThickness)
          .setY(j * (height / 3) + borderThickness)
          .setColor(Color.BLUE);
        box2D.onClick(e -> box2D.setColor(GameUtil.randomColor()));
        tektons.add(box2D);
      }
    }
  }
}
