package hu.baksaz.example.engine;

public class GameManager {

  private boolean shouldExit = false;
  private InputManager inputManager;

  public GameManager() {
  }

  public void startGame() {
    registerComponents();
    // main game loop
    while (!shouldExit) {
      ApplicationContext.getPublisher().publish(new GameTickEvent());
    }
  }

  /**
   * Initialize the game and register main parts ex.: InputManager
   */
  private void registerComponents() {
    inputManager = new InputManager();
  }

  public void stopGame() {
    shouldExit = true;
  }
}
