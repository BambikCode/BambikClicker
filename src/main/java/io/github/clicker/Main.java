package io.github.clicker;

import io.github.clicker.listener.KeyListener;
import io.github.clicker.listener.MouseListener;
import io.github.clicker.manager.ClickerManager;
import io.github.clicker.manager.SceneManager;
import io.github.clicker.scene.BindsScene;
import io.github.clicker.scene.LeftClickScene;
import io.github.clicker.scene.RightClickScene;
import io.github.clicker.scene.InformationsScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class Main extends Application {

    private static Stage stage;
    private static Main instance;
    private final ClickerManager manager = new ClickerManager();

    @Override
    public void start(Stage stage) throws NativeHookException {
        Main.instance = this;
        Main.stage = stage;
        SceneManager sceneManager = new SceneManager(stage);
        LeftClickScene leftClickScene = new LeftClickScene(sceneManager);
        RightClickScene rightClickScene = new RightClickScene(sceneManager);
        InformationsScene informationsScene = new InformationsScene(sceneManager);
        BindsScene bindsScene = new BindsScene(sceneManager, manager);
        sceneManager.addScreen("left", leftClickScene.getScene());
        sceneManager.addScreen("right", rightClickScene.getScene());
        sceneManager.addScreen("settings", informationsScene.getScene());
        sceneManager.addScreen("binds", bindsScene.getScene());
        stage.setTitle("BambikClicker");
        stage.setResizable(false);
        stage.setScene(leftClickScene.getScene());
        stage.setWidth(1100);
        stage.setHeight(670);
        stage.getIcons().add(new Image("bambik_logo.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.setOnCloseRequest(event -> System.exit(0));


        LogManager.getLogManager().reset();

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new KeyListener());
        GlobalScreen.addNativeMouseListener(new MouseListener());


    }

    public ClickerManager getClickerManager() {
        return manager;
    }

    public static Main getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStage() {
        return stage;
    }
}
