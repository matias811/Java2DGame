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
        tile = new Tile[35];
        mapTileNumber = new int[gamePanel.maxScreenColumn][gamePanel.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        TileLoaders tileLoaders = new TileLoaders();
        try {
            // GRASS TILE[0] and TILE[1]
            tileLoaders.loadGrass(tile);
            // ROAD TILE[2] to TILE[13]
            tileLoaders.loadRoads(tile);
            // WATER TILE[14] to TILE[23]
            tileLoaders.loadWater(tile);
            // TREE
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree.png")));
            // WALL
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            // HUT
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/hut.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(final Graphics2D g2D) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {

            int tileNum = mapTileNumber[col][row];

            g2D.drawImage(tile[tileNum].image, x, y, gamePanel.actualTileSize, gamePanel.actualTileSize, null);
            col++;
            x += gamePanel.actualTileSize;

            if (col == gamePanel.maxScreenColumn) {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.actualTileSize;
            }
        }
    }

    public void loadMap() {
        try {
            InputStream mapInput = getClass().getResourceAsStream("/maps/map01.txt");
            assert mapInput != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(mapInput));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {
                String line = reader.readLine();

                while (col < gamePanel.maxScreenColumn) {
                    String[] numbers = line.split(" ");

                    // Using col as index for the numbers line
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxScreenColumn) {
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
