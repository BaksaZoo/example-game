package hu.baksaz.example.game;

import hu.baksaz.example.engine.*;
import java.awt.event.KeyEvent;

public class GameManager {
    private final Game game;

    public GameManager() {
        game = new Game("Game Window", 800, 600);

        ApplicationContext.getPublisher().subscribe(KeyEvent.class, this::handleInput);
    }
    
    public void start() {
        initGameObjects();
        game.startGame();
    }

    private void initGameObjects() {
        Player player = new Player();
    }

    private void handleInput(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.stopGame();
        }
    }
}
