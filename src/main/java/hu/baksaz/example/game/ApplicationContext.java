package hu.baksaz.example.game;

public class ApplicationContext {

  private static ApplicationEventPublisher publisher = new ApplicationEventPublisher();

  public static ApplicationEventPublisher getPublisher() {
    return publisher;
  }
}
