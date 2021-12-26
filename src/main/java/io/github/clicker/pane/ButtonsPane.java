package io.github.clicker.pane;

import io.github.clicker.button.ClickerButton;
import io.github.clicker.manager.SceneManager;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public final class ButtonsPane extends Pane {

    private final ClickerButton[] clickerButtons = new ClickerButton[4];
    private final String[] texts = {"Lewy przycisk", "Prawy przycisk", "Bindy", "Informacje"};
    private final String[] icons = {"left-mouse.png", "right-mouse-click.png", "keyboard.png", "informations.png"};

    public ButtonsPane(SceneManager sceneManager) {
        this.setPrefWidth(300);
        this.setPrefHeight(700);
        for (int i = 0; i < clickerButtons.length; i++) {
            clickerButtons[i] = new ClickerButton(texts[i]);
            clickerButtons[i].setTranslateY(60d+(140*i));
            clickerButtons[i].setLayoutX(0);
            ImageView image = new ImageView(icons[i]);
            image.setPreserveRatio(true);
            clickerButtons[i].setGraphic(image);
            clickerButtons[i].setGraphicTextGap(10);
            this.getChildren().add(clickerButtons[i]);
        }
        this.setStyle("-fx-background-color: #181E36");
        clickerButtons[0].setOnMouseReleased(event -> sceneManager.switchScene("left"));
        clickerButtons[1].setOnMouseReleased(event -> sceneManager.switchScene("right"));
        clickerButtons[2].setOnMouseReleased(event -> sceneManager.switchScene("binds"));
        clickerButtons[3].setOnMouseReleased(event -> sceneManager.switchScene("informations"));
    }
}
