package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(final GamePanel gamePanel, final KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
    }

    public void setDefaultAttributes() {
        x = 100;
        y = 100;
        speed = 5;
    }
}
