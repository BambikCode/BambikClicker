package io.github.clicker.manager;

import io.github.clicker.tasks.LeftClickerTask;
import io.github.clicker.tasks.RightClickerTask;
import org.jnativehook.keyboard.NativeKeyEvent;

public final class ClickerManager {

    private final LeftClickerTask leftClickerTask;
    private final RightClickerTask rightClickerTask;
    private boolean isLeftButtonPressed;
    private boolean isRightButtonPressed;
    private int rightClickKey = NativeKeyEvent.VC_8;
    private int leftClickKey = NativeKeyEvent.VC_9;
    private boolean isListeningLeft;
    private boolean isListeningRight;

    public ClickerManager() {
        this.leftClickerTask = new LeftClickerTask();
        this.rightClickerTask = new RightClickerTask();
    }

    public int getLeftClickKey() {
        return leftClickKey;
    }
    public int getRightClickKey() {
        return rightClickKey;
    }

    public void setLeftClickKey(int leftClickKey) {
        this.leftClickKey = leftClickKey;
    }
    public void setRightClickKey(int rightClickKey) {
        this.rightClickKey = rightClickKey;
    }

    public LeftClickerTask getLeftClickerTask() {
        return leftClickerTask;
    }
    public RightClickerTask getRightClickerTask() {
        return rightClickerTask;
    }

    public boolean isLeftButtonPressed() {
        return isLeftButtonPressed;
    }

    public void setLeftButtonPressed(boolean leftButtonPressed) {
        isLeftButtonPressed = leftButtonPressed;
    }

    public boolean isRightButtonPressed() {
        return isRightButtonPressed;
    }

    public void setRightButtonPressed(boolean rightButtonPressed) {
        isRightButtonPressed = rightButtonPressed;
    }

    public boolean isListeningLeft() {
        return isListeningLeft;
    }

    public void setListeningLeft(boolean listeningLeft) {
        isListeningLeft = listeningLeft;
    }

    public boolean isListeningRight() {
        return isListeningRight;
    }

    public void setListeningRight(boolean listeningRight) {
        isListeningRight = listeningRight;
    }
}