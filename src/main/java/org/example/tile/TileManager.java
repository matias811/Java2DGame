package org.example.tile;

import org.example.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int[][] mapTileNumber;

    public TileManager(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[40];
        mapTileNumber = new int[gamePanel.maxWorldColumn][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage() {
        TileLoaders tileLoaders = new TileLoaders();
        try {
            tileLoaders.loadGrassAndRoads(tile);
            tileLoaders.loadWaters(tile);
            // WALL
            tile[32] = new Tile();
            tile[32].collision = true;
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/032.png")));
            // HUT
            tile[33] = new Tile();
            tile[33].collision = true;
            tile[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/033.png")));
            // WOOD FLOOR
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/034.png")));
            // TABLE
            tile[35] = new Tile();
            tile[35].collision = true;
            tile[35].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/035.png")));
            // STAIRS
            tile[36] = new Tile();
            tile[36].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/036.png")));
            // FLOATING STAIRS
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/037.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(final Graphics2D g2D) {
        int worldColumn = 0;
        int worldRow = 0;
        while (worldColumn < gamePanel.maxWorldColumn && worldRow < gamePanel.maxWorldRow) {

            int tileNum = mapTileNumber[worldColumn][worldRow];

            int worldX = worldColumn * gamePanel.actualTileSize;
            int worldY = worldRow * gamePanel.actualTileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX + gamePanel.actualTileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.actualTileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.actualTileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.actualTileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                g2D.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.actualTileSize, gamePanel.actualTileSize, null);
            }

            worldColumn++;

            if (worldColumn == gamePanel.maxWorldColumn) {
                worldColumn = 0;
                worldRow++;
            }
        }
    }

    public void loadMap(final String map) {
        try {
            InputStream mapInput = getClass().getResourceAsStream(map);
            assert mapInput != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(mapInput));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldColumn && row < gamePanel.maxWorldRow) {
                String line = reader.readLine();

                while (col < gamePanel.maxWorldColumn) {
                    String[] numbers = line.split(" ");

                    // Using col as index for the numbers line
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxWorldColumn) {
                    col = 0;
                    row++;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
