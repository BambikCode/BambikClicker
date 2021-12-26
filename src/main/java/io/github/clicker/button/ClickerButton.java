package io.github.clicker.button;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.Glow;
import javafx.scene.text.Font;

public final class ClickerButton extends Button {

    public ClickerButton(String title) {
        this.setText(title);
        this.setOnMouseEntered(event -> this.setEffect(new Glow(0.35)));
        this.setOnMouseExited(event -> this.setEffect(null));
        this.setFont(Font.font("Verdana", 25));
        this.setStyle("-fx-background-radius: 20px; -fx-background-color: #181E36; -fx-text-fill: #2a3b66;");
        this.setContentDisplay(ContentDisplay.RIGHT);
        this.setAlignment(Pos.BASELINE_LEFT);
        this.setPrefWidth(300);
        this.setPrefHeight(130);
    }
}
