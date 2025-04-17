package hu.baksaz.example.game;

public class GameManager {

  private boolean shouldExit = false;
  private InputManager inputManager;

  public GameManager() {
    ApplicationContext.getPublisher().subscribe(InputEvent.class, this::handleEvent);
  }

  public void startGame() {
    registerComponents();
    // main game loop
    while (!shouldExit) {
      ApplicationContext.getPublisher().publish(new GameTickEvent());
    }
  }

  /**
   * Initialize game and register main components ex.: InputManager
   */
  private void registerComponents() {
    inputManager = new InputManager();
  }

  private void handleEvent(InputEvent event) {
    shouldExit = true;
  }
}
