package io.github.clicker.scene;

import io.github.clicker.Main;
import io.github.clicker.bar.TopBar;
import io.github.clicker.manager.SceneManager;
import io.github.clicker.pane.ButtonsPane;
import io.github.clicker.tasks.LeftClickerTask;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public final class LeftClickScene extends AnchorPane {

    private final Text cpsText;
    private final Text sceneText;
    private final LeftClickerTask leftClickerTask = Main.getInstance().getClickerManager().getLeftClickerTask();

    public LeftClickScene(SceneManager sceneManager) {

        new Scene(this);

        this.cpsText = new Text();

        cpsText.setText("CPS: 1");

        cpsText.setTranslateX(620);
        cpsText.setTranslateY(300);
        cpsText.setFont(Font.font("Roboto", 40));
        cpsText.setStyle("-fx-fill: #405382;");

        this.getChildren().add(configureSlider());

        this.setStyle("-fx-background-color: #2e3349;");

        this.getChildren().add(new ButtonsPane(sceneManager));
        this.getChildren().add(cpsText);
        this.sceneText = new Text();
        sceneText.setText("Lewy przycisk myszy");
        sceneText.setTranslateX(500);
        sceneText.setTranslateY(100);
        sceneText.setFont(Font.font("Roboto", 40));
        sceneText.setStyle("-fx-fill: #405382;");
        this.getChildren().add(sceneText);
        this.getChildren().add(new TopBar());
    }

    private Slider configureSlider() {
        Slider slider = new Slider();
        slider.setId("slider");
        slider.setMax(50);
        slider.setPrefSize(600, 125);
        slider.setTranslateX(425);
        slider.setTranslateY(125);
        slider.setMinorTickCount(1);
        slider.setMajorTickUnit(5);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setShowTickLabels(true);
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.valueProperty().addListener((ov, old, newNum) -> {
            cpsText.setText("CPS: " + newNum.intValue());
            leftClickerTask.setDelay(newNum.intValue());
        });
        slider.setValue(1);
        this.getStylesheets().add(Main.class.getResource("/style.css").toExternalForm());
        return slider;
    }
}
