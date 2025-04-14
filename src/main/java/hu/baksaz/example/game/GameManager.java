package hu.baksaz.example.game;

public class GameManager implements ApplicationEventListener<InputEvent> {

  private boolean shouldExit = false;
  private InputManager inputManager;

  public GameManager() {
    ApplicationContext.getPublisher().listen(this);
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

  @Override
  public void onApplicationEvent(InputEvent event) {
    shouldExit = true;
  }
}
