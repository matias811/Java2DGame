package org.example.tile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class TileLoaders {
    public void loadGrassAndRoads(final Tile[] tile) throws IOException {
        for (int i = 0; i <= 17; i++) {
            tile[i] = new Tile();
            if (i < 10) {
                tile[i].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/00" + i + ".png")));
            } else {
                tile[i].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/0" + i + ".png")));
            }
        }
        // TREE TILE
        tile[16].collision = true;
    }

    public void loadWaters(final Tile[] tile) throws IOException {
        for (int i = 18; i <= 31; i++) {
            tile[i] = new Tile();
            tile[i].collision = true;
            tile[i].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/0" + i + ".png")));
        }
    }
}
