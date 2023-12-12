package org.example.object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Shield extends SuperObject {
    public OBJ_Shield() {
        name = "Shield";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/shield_wood.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
