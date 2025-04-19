package hu.baksaz.example.engine;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Box2D {
  private int width;
  private int height;
  private int x;
  private int y;
  private Color color = Color.BLACK;

  private List<Listener<MouseEvent>> clickListeners = new ArrayList<>();

  public Box2D() {
    ApplicationContext.getPublisher().subscribe(GameTickEvent.class, this::render);
    ApplicationContext.getPublisher().subscribe(MouseEvent.class, this::handleClick);
  }

  private void render(GameTickEvent e) {
    var g = ApplicationContext.getPanel().getGraphics();
    g.setColor(color);
    g.fillRect(x, y, width, height);
    g.setColor(Color.WHITE);
    g.drawRect(x, y, width, height);
  }

  public void onClick(Listener<MouseEvent> listener) {
    clickListeners.add(listener);
  }

  private void handleClick(MouseEvent clickEvent) {
    if (clickEvent.getX() > x && clickEvent.getX() < x + width &&
        clickEvent.getY() > y && clickEvent.getY() < y + height) {
      clickListeners.forEach(listener -> listener.handleEvent(clickEvent));
    }
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

  public Color getColor() {
    return color;
  }

  public Box2D setColor(Color color) {
    this.color = color;
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
