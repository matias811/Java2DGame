package org.example.object;

import org.example.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX;
    public int worldY;

    public void draw(final Graphics2D g2D, GamePanel gamePanel) {

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        if (worldX + gamePanel.actualTileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.actualTileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.actualTileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.actualTileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
            g2D.drawImage(image, screenX, screenY, gamePanel.actualTileSize, gamePanel.actualTileSize, null);
        }
    }
}
