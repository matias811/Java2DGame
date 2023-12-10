package org.example.tile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class TileLoaders {
    public void loadGrassAndRoads(final Tile[] tile) throws IOException {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/000.png")));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/001.png")));

        tile[2] = new Tile();
        tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/002.png")));

        tile[3] = new Tile();
        tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/003.png")));

        tile[4] = new Tile();
        tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/004.png")));

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/005.png")));

        tile[6] = new Tile();
        tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/006.png")));

        tile[7] = new Tile();
        tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/007.png")));

        tile[8] = new Tile();
        tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/008.png")));

        tile[9] = new Tile();
        tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/009.png")));

        tile[10] = new Tile();
        tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/010.png")));

        tile[11] = new Tile();
        tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/011.png")));

        tile[12] = new Tile();
        tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/012.png")));

        tile[13] = new Tile();
        tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/013.png")));

        tile[14] = new Tile();
        tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/014.png")));

        tile[15] = new Tile();
        tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/015.png")));

        tile[16] = new Tile();
        tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/016.png")));

        tile[17] = new Tile();
        tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/017.png")));
    }
    public void loadWaters(final Tile[] tile) throws IOException {
        tile[18] = new Tile();
        tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/018.png")));

        tile[19] = new Tile();
        tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/019.png")));

        tile[20] = new Tile();
        tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/020.png")));

        tile[21] = new Tile();
        tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/021.png")));

        tile[22] = new Tile();
        tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/022.png")));

        tile[23] = new Tile();
        tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/023.png")));

        tile[24] = new Tile();
        tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/024.png")));

        tile[25] = new Tile();
        tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/025.png")));

        tile[26] = new Tile();
        tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/026.png")));

        tile[27] = new Tile();
        tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/027.png")));

        tile[28] = new Tile();
        tile[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/028.png")));

        tile[29] = new Tile();
        tile[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/029.png")));

        tile[30] = new Tile();
        tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/030.png")));

        tile[31] = new Tile();
        tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/031.png")));
    }
}
