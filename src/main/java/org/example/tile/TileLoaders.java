package org.example.tile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class TileLoaders {
    public void loadGrass(final Tile[] tile) throws IOException {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass00.png")));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass01.png")));
    }

    public void loadRoads(final Tile[] tile) throws IOException {
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road00.png")));

        tile[3] = new Tile();
        tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road01.png")));

        tile[4] = new Tile();
        tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road02.png")));

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road03.png")));

        tile[6] = new Tile();
        tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road04.png")));

        tile[7] = new Tile();
        tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road05.png")));

        tile[8] = new Tile();
        tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road06.png")));

        tile[9] = new Tile();
        tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road07.png")));

        tile[10] = new Tile();
        tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road08.png")));

        tile[11] = new Tile();
        tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road09.png")));

        tile[12] = new Tile();
        tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road10.png")));

        tile[12] = new Tile();
        tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road11.png")));

        tile[13] = new Tile();
        tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road12.png")));
    }

    public void loadWater(final Tile[] tile) throws IOException {
        tile[14] = new Tile();
        tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water00.png")));

        tile[15] = new Tile();
        tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water01.png")));

        tile[16] = new Tile();
        tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water02.png")));

        tile[17] = new Tile();
        tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water03.png")));

        tile[18] = new Tile();
        tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water04.png")));

        tile[19] = new Tile();
        tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water05.png")));

        tile[20] = new Tile();
        tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water06.png")));

        tile[21] = new Tile();
        tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water07.png")));

        tile[22] = new Tile();
        tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water08.png")));

        tile[23] = new Tile();
        tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water09.png")));

        tile[24] = new Tile();
        tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water10.png")));

        tile[25] = new Tile();
        tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water11.png")));

        tile[26] = new Tile();
        tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water12.png")));

        tile[27] = new Tile();
        tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water13.png")));
    }
}
