package org.example;

import org.example.entity.Player;
import org.example.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16px X 16px - Standard Tile Size for 2D Games
    final int scale = 3; // 16px x 3(scale) = 48px
    public final int actualTileSize = originalTileSize * scale; // 48px X 48px - Scaled Tile Size for Modern Screens
    public final int maxScreenColumn = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = actualTileSize * maxScreenColumn; // 768px
    public final int screenHeight = actualTileSize * maxScreenRow; // 576px

    // WORLD SETTINGS
    public final int maxWorldColumn = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = actualTileSize * maxWorldColumn;
    public final int worldHeight = actualTileSize * maxWorldRow;

    final double FPS = 60.0;
    final KeyHandler keyHandler = new KeyHandler();
    final TileManager tileManager = new TileManager(this);
    public final CollisionDetector collisionDetector = new CollisionDetector(this);
    Thread gameThread;
    public final Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    @Override
    public void run() {
        final double drawInterval = 1_000_000_000 / FPS;
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
        player.update();
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2D = (Graphics2D) g;

        tileManager.draw(g2D);
        player.drawPlayer(g2D);

        g2D.dispose();
    }
}
