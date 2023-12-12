package org.example.object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Coin extends SuperObject {
    public OBJ_Coin() {
        name = "Coin";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/coin_bronze.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
