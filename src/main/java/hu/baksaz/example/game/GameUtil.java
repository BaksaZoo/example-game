package hu.baksaz.example.game;

import java.awt.*;

public class GameUtil {

  private GameUtil() {
    throw new IllegalStateException("Utility class");
  }

  public static Color randomColor() {
    return new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
  }
}
