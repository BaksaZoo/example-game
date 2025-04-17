package hu.baksaz.example.engine;

import javax.swing.*;

public class ApplicationContext {

  private static ApplicationEventPublisher publisher = new ApplicationEventPublisher();
  private static JPanel panel;

  public static ApplicationEventPublisher getPublisher() {
    return publisher;
  }

  public static JPanel getPanel() {
    return panel;
  }

  public static void setPanel(JPanel panel) {
    ApplicationContext.panel = panel;
  }
}
