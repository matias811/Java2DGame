package org.example.object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Lantern extends SuperObject {
    public OBJ_Lantern() {
        name = "Lantern";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/lantern.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
