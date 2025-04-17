package hu.baksaz.example.engine;

public class Game {

  private boolean shouldExit = false;
  private InputManager inputManager;

  public Game() {
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
