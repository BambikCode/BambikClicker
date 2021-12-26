package io.github.clicker.listener;

import io.github.clicker.Main;
import io.github.clicker.manager.ClickerManager;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class MouseListener implements NativeMouseListener {

    private final ClickerManager clickerManager = Main.getInstance().getClickerManager();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        if (e.getButton() == NativeMouseEvent.BUTTON1 && clickerManager.isLeftButtonPressed()) {
            executor.execute(clickerManager.getLeftClickerTask());
        } else if (e.getButton() == NativeMouseEvent.BUTTON3 && clickerManager.isRightButtonPressed()) {
            executor.execute(clickerManager.getRightClickerTask());
        }
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
    }
}
