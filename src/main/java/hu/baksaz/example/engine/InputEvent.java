package hu.baksaz.example.engine;

public class InputEvent extends Event {
  private char key;

  public InputEvent(char key) {
    this.key = key;
  }

  public char getKey() {
    return key;
  }

  public InputEvent setKey(char key) {
    this.key = key;
    return this;
  }
}
