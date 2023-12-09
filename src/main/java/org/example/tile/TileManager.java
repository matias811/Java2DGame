package org.example.tile;

import org.example.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;

    public TileManager(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[35];

        getTileImage();
    }

    public void getTileImage() {
        TileLoaders tileLoaders = new TileLoaders();
        try {
            // GRASS TILE[0] and TILE[1]
            tileLoaders.loadGrass(tile);
            // ROAD TILE[2] to TILE[10]
            tileLoaders.loadRoads(tile);
            // WATER TILE[11] to TILE[20]
            tileLoaders.loadWater(tile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(final Graphics2D g2D) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (row < gamePanel.maxScreenRow) {
            while (col < gamePanel.maxScreenColumn) {
                g2D.drawImage(tile[1].image, x, y, gamePanel.actualTileSize, gamePanel.actualTileSize, null);
                x += gamePanel.actualTileSize;
                col += 1;
            }
            x = 0;
            col = 0;
            y += gamePanel.actualTileSize;
            row += 1;
        }
    }
}
