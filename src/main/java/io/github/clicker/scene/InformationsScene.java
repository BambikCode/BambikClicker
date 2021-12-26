package io.github.clicker.scene;

import io.github.clicker.bar.TopBar;
import io.github.clicker.manager.SceneManager;
import io.github.clicker.pane.ButtonsPane;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public final class InformationsScene extends AnchorPane {


    private final Text bambik;
    private final Text text;

    public InformationsScene(SceneManager sceneManager) {
        new Scene(this);
        this.bambik = new Text();
        this.text = new Text();
        text.setText("BambikClicker v1.0\nSkidded by fertiz & dx\nIkony: icons8.com");
        text.setTranslateX(550);
        text.setTranslateY(350);
        text.setFont(Font.font("Roboto", 30));
        text.setFill(Color.BLACK);
        bambik.setText("\u0042\u0041\u004D\u0042\u0049\u004B");

        bambik.setTranslateX(600);
        bambik.setTranslateY(200);
        bambik.setFont(Font.font("Roboto", 40));
        bambik.setFill(Color.RED);

        this.getChildren().add(bambik);
        this.getChildren().add(text);
        this.setStyle("-fx-background-color: #2E3349;");
        this.getChildren().add(new ButtonsPane(sceneManager));
        this.getChildren().add(new TopBar());
    }
}
