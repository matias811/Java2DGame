package org.example;

import org.example.object.*;

public class AssetSetter {

    final GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject() {
        gamePanel.obj[0] = new OBJ_Key();
        gamePanel.obj[0].worldX = 15 * gamePanel.actualTileSize;
        gamePanel.obj[0].worldY = 15 * gamePanel.actualTileSize;

        gamePanel.obj[1] = new OBJ_Key();
        gamePanel.obj[1].worldX = 17 * gamePanel.actualTileSize;
        gamePanel.obj[1].worldY = 15 * gamePanel.actualTileSize;

        gamePanel.obj[2] = new OBJ_Key();
        gamePanel.obj[2].worldX = 19 * gamePanel.actualTileSize;
        gamePanel.obj[2].worldY = 15 * gamePanel.actualTileSize;

        gamePanel.obj[3] = new OBJ_Key();
        gamePanel.obj[3].worldX = 21 * gamePanel.actualTileSize;
        gamePanel.obj[3].worldY = 15 * gamePanel.actualTileSize;

        gamePanel.obj[4] = new OBJ_Sword();
        gamePanel.obj[4].worldX = 15 * gamePanel.actualTileSize;
        gamePanel.obj[4].worldY = 17 * gamePanel.actualTileSize;

        gamePanel.obj[5] = new OBJ_Shield();
        gamePanel.obj[5].worldX = 17 * gamePanel.actualTileSize;
        gamePanel.obj[5].worldY = 17 * gamePanel.actualTileSize;



    }
}
