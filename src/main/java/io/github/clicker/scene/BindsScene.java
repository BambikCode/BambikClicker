package io.github.clicker.scene;

import io.github.clicker.bar.TopBar;
import io.github.clicker.manager.ClickerManager;
import io.github.clicker.manager.SceneManager;
import io.github.clicker.pane.ButtonsPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public final class BindsScene extends AnchorPane {

    private final ClickerManager clickerManager;

    public BindsScene(SceneManager sceneManager, ClickerManager clickerManager) {
        new Scene(this);
        this.clickerManager = clickerManager;
        this.setStyle("-fx-background-color: #2E3349;");
        this.getChildren().add(new ButtonsPane(sceneManager));
        this.getChildren().add(createLeftButton());
        this.getChildren().add(createRightButton());
        this.getChildren().add(new TopBar());
    }

    private Button createLeftButton() {
        Button button = new Button();
        button.setEffect(new Glow(0.3));
        button.setText("LPM: 9");
        button.setTranslateY(100);
        button.setTranslateX(350);
        button.setPrefSize(300, 200);
        button.setFont(Font.font("Verdana", 39));
        button.setStyle("-fx-background-color: #3c4066; -fx-border-radius: 15px; -fx-background-radius: 15px; -fx-text-fill: #24294f;");
        button.setOnMousePressed(event -> {
            clickerManager.setListeningLeft(true);
            button.setEffect(new InnerShadow(1, Color.GRAY));
        });
        button.setOnKeyPressed(event -> {
            if (clickerManager.isListeningLeft()) {
                button.setText("LPM: " + event.getText());
                clickerManager.setListeningLeft(false);
                button.setEffect(new Glow(0.3));
            }
        });
        return button;
    }

    private Button createRightButton() {
        Button button = new Button();
        button.setEffect(new Glow(0.3));
        button.setText("PPM: 8");
        button.setTranslateY(100);
        button.setTranslateX(750);
        button.setPrefSize(300, 200);
        button.setFont(Font.font("Verdana", 39));
        button.setStyle("-fx-background-color: #3c4066; -fx-background-radius: 15px; -fx-text-fill: #24294f;");
        button.setOnMousePressed(event -> {
            clickerManager.setListeningRight(true);
            button.setEffect(new InnerShadow(1, Color.GRAY));
        });
        button.setOnKeyPressed(event -> {
            if (clickerManager.isListeningRight()) {
                button.setText("PPM: " + event.getText());
                clickerManager.setListeningRight(false);
                button.setEffect(new Glow(0.3));
            }
        });
        return button;
    }
}
