package org.example.ui;

import org.example.GamePanel;
import org.example.object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gamePanel;
    Font arial_40;
    BufferedImage keyImage;

    public UI(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_Key objKey = new OBJ_Key();
        this.keyImage = objKey.image;
    }

    public void draw(final Graphics2D g2D) {
        g2D.setFont(arial_40);
        g2D.setColor(Color.WHITE);
        for (int i = 1; i < gamePanel.player.keys + 1; i++) {
            g2D.drawImage(keyImage, gamePanel.actualTileSize / 4 * i, gamePanel.actualTileSize / 4, gamePanel.actualTileSize / 2, gamePanel.actualTileSize / 2, null);
        }
    }
}
