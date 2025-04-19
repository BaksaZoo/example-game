package hu.baksaz.example.engine;

import javax.swing.*;

public class ApplicationContext {

  private static ApplicationEventPublisher publisher = new ApplicationEventPublisher();
  private static JPanel panel;
  private static WindowManager windowManager;

  public static ApplicationEventPublisher getPublisher() {
    return publisher;
  }

  public static WindowManager getWindowManager() {
    return windowManager;
  }

  public static void setWindowManager(WindowManager windowManager) {
    ApplicationContext.windowManager = windowManager;
  }

  public static JPanel getPanel() {
    return panel;
  }

  public static void setPanel(JPanel panel) {
    ApplicationContext.panel = panel;
  }
}
