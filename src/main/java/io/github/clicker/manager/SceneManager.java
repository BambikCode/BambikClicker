package io.github.clicker.manager;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public final class SceneManager {

    private final Map<String, Scene> screenMap;
    private final Stage stage;

    public void addScreen(String name, Scene scene) {
        screenMap.put(name, scene);
    }

    public SceneManager(Stage stage) {
        this.stage = stage;
        this.screenMap = new HashMap<>();
    }

    public void switchScene(String name) {
        stage.setScene(screenMap.get(name));
    }
}
