import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainScreen extends Application {
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setTop(new CustomPane("Jared, David, and Mark Land"));
        borderPane.setCenter(gridPane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Button level1 = new Button("Level 1");
        level1.setShape(new Circle(350));
        level1.setMaxSize(350, 350);
        gridPane.add(level1, 0, 0);

        Button level2 = new Button("Level 2");
        level2.setShape(new Circle(15));
        level2.setMaxSize(350,350);
        gridPane.add(level2, 2, 0);

        Rectangle filler1 = new Rectangle(45, 45);
        filler1.setFill(Color.WHITE);
        filler1.setStroke(Color.WHITE);
        gridPane.add(filler1, 1,0);

        Button level3 = new Button("Level 3");
        level3.setShape(new Circle(350));
        level3.setMaxSize(350, 350);
        gridPane.add(level3, 4, 0);

        Rectangle filler2 = new Rectangle(45, 45);
        filler2.setFill(Color.WHITE);
        filler2.setStroke(Color.WHITE);
        gridPane.add(filler2, 3, 0);

        level1.setOnMousePressed(e -> {
            Level_1 lvl1 = new Level_1();
            Scene scene = new Scene(lvl1, 800, 500);
            scene.setOnKeyPressed(a -> {
                if (a.getCode() == KeyCode.LEFT)
                    lvl1.getPlayer().jumpLeft();
                else if (a.getCode() == KeyCode.RIGHT)
                    lvl1.getPlayer().jumpRight();
            });
            scene.setOnKeyReleased(b -> lvl1.getPlayer().gravity());
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.requestFocus();
        });


        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setTitle("Better Flappy Golf");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}

class CustomPane extends StackPane {
    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}