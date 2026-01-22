import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallAndGrid extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ball and Grid");

        final double width = 600;
        final double height = 600;

        Label[][] labels = new Label[3][3];

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);

        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                labels[i][j] = new Label("#,# ");
                grid.add(labels[i][j], i, j);
            }
        }

        //create scene
        Scene scene = new Scene(grid, width, height);
        scene.setOnMouseClicked(event -> {

            double x = event.getX();
            double y = event.getY();

            int intX = (int) Math.floor(x / 200);
            int intY = (int) Math.floor(y / 200);

            labels[intX][intY].setText(intX + "," + intY + " ");

        });
        //show scene
        scene.getStylesheets().add("Stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
