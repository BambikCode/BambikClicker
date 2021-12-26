package io.github.clicker.bar;


import io.github.clicker.Main;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public final class TopBar extends HBox {

    private final Text title;

    private final DropShadow dropShadow;

    private double xOffset = 0;
    private double yOffset = 0;

    public TopBar() {
        this.title = new Text();

        title.setText("BambikClicker");
        title.setTranslateX(400);
        title.setTranslateY(1);
        title.setFont(Font.font("Roboto",  30));
        title.setStyle("-fx-fill: #181E36;");
        title.setEffect(new Glow(0.3));
        this.dropShadow = new DropShadow();
        /*dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setRadius(10);
        dropShadow.setColor(Color.WHITE);
        title.setEffect(dropShadow);*/

        this.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        this.setOnMouseDragged(event -> {
            Main.getInstance().getStage().setX(event.getScreenX() - xOffset);
            Main.getInstance().getStage().setY(event.getScreenY() - yOffset);
        });


        this.setStyle("-fx-background-color: #3C4257;");

        this.setPrefSize(1200, 40);
        this.setVisible(true);

        registerExitButton();
        registerMinimizeButton();
        this.getChildren().add(title);
    }

    private void registerExitButton() {

        ImageView exit = new ImageView("exit_blank_logo.png");

        exit.setFitHeight(37);
        exit.setFitWidth(37);
        exit.setTranslateX(1040);
        exit.setTranslateY(3);

        this.getChildren().add(exit);

        exit.setOnMouseEntered(event -> {
            exit.setImage(new Image("exit_logo.png"));
            exit.setEffect(new Glow(0.3));
        });

        exit.setOnMouseExited(event -> {
            exit.setImage(new Image("exit_blank_logo.png"));
            exit.setEffect(null);
        });

        exit.setOnMousePressed(event ->
                System.exit(0)
        );
    }

    private void registerMinimizeButton() {

        ImageView minimize = new ImageView("minimize_blank_logo.png");

        minimize.setFitHeight(37);
        minimize.setFitWidth(37);
        minimize.setTranslateX(950);
        minimize.setTranslateY(3);

        minimize.setOnMouseEntered(event -> {
            minimize.setImage(new Image("minimize_logo.png"));
            minimize.setEffect(new Glow(0.3));
        });

        minimize.setOnMouseExited(event -> {
                minimize.setImage(new Image("minimize_blank_logo.png"));
                minimize.setEffect(null);
        });

        minimize.setOnMousePressed(event ->
                Main.getInstance().getStage().setIconified(true)
        );

        this.getChildren().add(minimize);
    }
}
