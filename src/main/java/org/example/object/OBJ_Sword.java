package org.example.object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Sword extends SuperObject {
    public OBJ_Sword() {
        name = "Sword";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/sword_normal.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
