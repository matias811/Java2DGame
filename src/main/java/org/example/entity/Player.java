package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;
    public int keys = 0;
    public boolean sword = false;

    public Player(final GamePanel gamePanel, final KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - (gamePanel.actualTileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.actualTileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultAttributes();
        getPlayerImage();
    }

    public void setDefaultAttributes() {
        worldX = gamePanel.actualTileSize * 10;
        worldY = gamePanel.actualTileSize * 15;
        speed = 5;
        direction = "down";
    }

    public void update() {
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            }
            if (keyHandler.rightPressed) {
                direction = "right";
            }
            if (keyHandler.downPressed) {
                direction = "down";
            }
            if (keyHandler.leftPressed) {
                direction = "left";
            }

            collisionOn = false;
            gamePanel.collisionDetector.checkTile(this);
            int objIndex = gamePanel.collisionDetector.checkObject(this, true);
            pickUpObject(objIndex);
            if (!collisionOn) {
                switch(direction) {
                    case "up" -> worldY -= speed;
                    case "right" -> worldX += speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) spriteNumber = 2;
                else if (spriteNumber == 2) spriteNumber = 1;
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(final int index) {
        if (index != 999) {
            switch (gamePanel.obj[index].name) {
                case "Key" -> {
                    keys++;
                    System.out.println("Key Collected!");
                }
                case "Sword" -> {
                    sword = true;
                    System.out.println("Sword Collected");
                }
            }
            gamePanel.obj[index] = null;
        }
    }

    public void drawPlayer(final Graphics2D g2D) {
        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNumber == 1) image = up1;
                if (spriteNumber == 2) image = up2;
            }
            case "down" -> {
                if (spriteNumber == 1) image = down1;
                if (spriteNumber == 2) image = down2;
            }
            case "left" -> {
                if (spriteNumber == 1) image = left1;
                if (spriteNumber == 2) image = left2;
            }
            case "right" -> {
                if (spriteNumber == 1) image = right1;
                if (spriteNumber == 2) image = right2;
            }
        }

        g2D.drawImage(image, screenX, screenY, gamePanel.actualTileSize, gamePanel.actualTileSize, null);
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/WalkingSprites/boy_right_2.png")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
