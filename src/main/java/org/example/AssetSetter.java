package org.example;

import org.example.object.OBJ_Key;

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
        gamePanel.obj[1].worldX = 25 * gamePanel.actualTileSize;
        gamePanel.obj[1].worldY = 15 * gamePanel.actualTileSize;
    }
}
