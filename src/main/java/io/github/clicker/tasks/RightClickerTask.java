package io.github.clicker.tasks;

import java.awt.*;
import java.awt.event.InputEvent;

public final class RightClickerTask implements Runnable {


    private boolean isActive;
    private Robot robot;
    private int cps = 1;

    public RightClickerTask() {

        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void changeActive() {
        isActive = !isActive;
    }

    public void setDelay(int cps) {
        this.cps = cps;
    }

    @Override
    public void run() {
        while (isActive) {
            robot.mousePress(InputEvent.BUTTON3_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
            if (cps != 0) robot.delay(960/cps);
        }
    }
}
