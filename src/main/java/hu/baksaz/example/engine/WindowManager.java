package hu.baksaz.example.engine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowManager {
  private final String title;
  private final int width;
  private final int height;
  private JPanel panel;
  private JFrame frame;

  public WindowManager(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;
  }

  public void init() {
    // Create the main window
    frame = new JFrame(title);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // Create a panel that will receive keyboard focus
    panel = new JPanel();
    panel.setBackground(Color.BLACK);
    panel.setFocusable(true);
    frame.add(panel);
    ApplicationContext.setPanel(panel);

    panel.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        ApplicationContext.getPublisher().publish(e);
      }
    });
    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        ApplicationContext.getPublisher().publish(e);
      }
    });
  }

  public void show() {
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    panel.requestFocusInWindow();
  }

  public void close() {
    frame.dispose();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
