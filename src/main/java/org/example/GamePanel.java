package org.example;

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
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            updateFrameData();
            repaint(); // repaint calls paintComponent(Graphics g) method

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1_000_000; // Transform into milliseconds

                if (remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
