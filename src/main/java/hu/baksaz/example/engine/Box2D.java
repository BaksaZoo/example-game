package hu.baksaz.example.engine;

import java.awt.*;
import java.util.StringJoiner;

public class Box2D {
  private int width;
  private int height;
  private int x;
  private int y;

  public Box2D() {
    ApplicationContext.getPublisher().subscribe(GameTickEvent.class, this::render);
  }

  private void render(GameTickEvent e) {
    var g = ApplicationContext.getPanel().getGraphics();
    g.setColor(Color.CYAN);
//    g.drawRect(x, y, width, height);
    g.fillRect(x, y, width, height);
  }

  public int getWidth() {
    return width;
  }

  public Box2D setWidth(int width) {
    this.width = width;
    return this;
  }

  public int getHeight() {
    return height;
  }

  public Box2D setHeight(int height) {
    this.height = height;
    return this;
  }

  public int getX() {
    return x;
  }

  public Box2D setX(int x) {
    this.x = x;
    return this;
  }

  public int getY() {
    return y;
  }

  public Box2D setY(int y) {
    this.y = y;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Box2D.class.getSimpleName() + "[", "]")
      .add("width=" + width)
      .add("height=" + height)
      .add("x=" + x)
      .add("y=" + y)
      .toString();
  }
}
