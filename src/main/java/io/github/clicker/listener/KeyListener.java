package io.github.clicker.listener;

import io.github.clicker.Main;
import io.github.clicker.manager.ClickerManager;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public final class KeyListener implements NativeKeyListener {

    private final ClickerManager clickerManager = Main.getInstance().getClickerManager();

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

        if (e.getKeyCode() == clickerManager.getLeftClickKey()) {

            clickerManager.setLeftButtonPressed(true);
            clickerManager.getLeftClickerTask().changeActive();

        } else if (e.getKeyCode() == clickerManager.getRightClickKey()) {

            clickerManager.setRightButtonPressed(true);
            clickerManager.getRightClickerTask().changeActive();

        } else if (clickerManager.isListeningRight()) {

            clickerManager.setRightClickKey(e.getKeyCode());

        } else if (clickerManager.isListeningLeft()) {

            clickerManager.setLeftClickKey(e.getKeyCode());
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == clickerManager.getLeftClickKey()) {
            clickerManager.setLeftButtonPressed(false);
        } else if (e.getKeyCode() == clickerManager.getRightClickKey()) {
            clickerManager.setRightButtonPressed(false);
        }
    }
}
