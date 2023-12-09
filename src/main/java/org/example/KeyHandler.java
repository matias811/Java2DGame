package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean leftPressed = false;
    public boolean rightPressed = false;

    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO: NOTHING, IT'S NOT NEEDED
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> {
                upPressed = true;
            }
            case KeyEvent.VK_A -> {
                leftPressed = true;
            }
            case KeyEvent.VK_S -> {
                downPressed = true;
            }
            case KeyEvent.VK_D -> {
                rightPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> {
                upPressed = false;
            }
            case KeyEvent.VK_A -> {
                leftPressed = false;
            }
            case KeyEvent.VK_S -> {
                downPressed = false;
            }
            case KeyEvent.VK_D -> {
                rightPressed = false;
            }
        }
    }
}
