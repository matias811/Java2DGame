package org.example;

import org.example.entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16px X 16px - Standard Tile Size for 2D Games
    final int scale = 3; // 16px x 3(scale) = 48px
    final int actualTileSize = originalTileSize * scale; // 48px X 48px - Scaled Tile Size for Modern Screens
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = actualTileSize * maxScreenColumn; // 768px
    final int screenHeight = actualTileSize * maxScreenRow; // 576px

    final double FPS = 60.0;

    // PLAYER DEFAULT STARTING POSITION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long previousTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / drawInterval;
            previousTime = currentTime;

            if (delta >= 1) {
                updateFrameData();
                repaint(); // repaint calls paintComponent(Graphics g) method
                delta--;
            }
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void updateFrameData() {
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.white);
        g2D.fillRect(playerX, playerY, actualTileSize, actualTileSize);

        g2D.dispose();
    }
}
