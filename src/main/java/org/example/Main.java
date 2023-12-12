package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        // DEFAULT STARTING OPTIONS
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Java Game");

        // INSTANTIATING GAME PANEL CLASS AND DISPLAYING THE GAME SCREEN
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // STARTING GAME "CLOCK"
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}