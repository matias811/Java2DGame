package org.example;

import org.example.entity.Entity;

public class CollisionDetector {

    private final GamePanel gamePanel;

    public CollisionDetector(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(final Entity entity) {

        int entitySolidAreaLeftX = entity.worldX + entity.solidArea.x;
        int entitySolidAreaRightX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entitySolidAreaTopY = entity.worldY + entity.solidArea.y;
        int entitySolidAreaBottomY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entitySolidAreaLeftX / gamePanel.actualTileSize;
        int entityRightCol = entitySolidAreaRightX / gamePanel.actualTileSize;
        int entityTopRow = entitySolidAreaTopY / gamePanel.actualTileSize;
        int entityBottomRow = entitySolidAreaBottomY / gamePanel.actualTileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entitySolidAreaTopY - entity.speed) / gamePanel.actualTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entitySolidAreaBottomY + entity.speed) / gamePanel.actualTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entitySolidAreaLeftX - entity.speed) / gamePanel.actualTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entitySolidAreaRightX + entity.speed) / gamePanel.actualTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(final Entity entity, final boolean isPlayer) {
        int index = 999;
        for (int i = 0; i < gamePanel.obj.length; i++) {
            if (gamePanel.obj[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;

                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidAreaDefaultY;

                switch (entity.direction) {
                    case "up" -> {
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collision) entity.collisionOn = true;
                            if (isPlayer) index = i;
                        }
                    }
                    case "down" -> {
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collision) entity.collisionOn = true;
                            if (isPlayer) index = i;
                        }
                    }
                    case "left" -> {
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collision) entity.collisionOn = true;
                            if (isPlayer) index = i;
                        }
                    }
                    case "right" -> {
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collision) entity.collisionOn = true;
                            if (isPlayer) index = i;
                        }
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
