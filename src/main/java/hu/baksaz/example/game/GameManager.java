package hu.baksaz.example.game;

import hu.baksaz.example.engine.*;
import java.awt.event.KeyEvent;

public class GameManager {
    private final Game game;

    public GameManager() {
        game = new Game("Game Window", 800, 600);

        ApplicationContext.getPublisher().subscribe(InputEvent.class, this::handleInput);
    }
    
    public void start() {
        game.startGame();
    }
    
    private void handleInput(InputEvent event) {
        if (event.getKey() == KeyEvent.VK_ESCAPE) {
            game.stopGame();
        }
    }
}
