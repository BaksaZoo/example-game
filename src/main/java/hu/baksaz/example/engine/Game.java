package hu.baksaz.example.engine;

public class Game {

  private boolean shouldExit = false;
  private WindowManager windowManager;

  public Game(String title, int width, int height) {
    windowManager = new WindowManager(title, width, height);
  }

  public void startGame() {
    initComponents();

    // main game loop
    while (!shouldExit) {
      ApplicationContext.getPublisher().publish(new GameTickEvent());

      windowManager.show();
    }
  }

  /**
   * Initialize the game and register main parts ex.: InputManager
   */
  private void initComponents() {
    windowManager.init();
    windowManager.show();
  }

  public void stopGame() {
    windowManager.close();
    shouldExit = true;
  }
}
