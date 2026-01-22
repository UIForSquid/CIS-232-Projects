import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyFirstMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("One Menu To Rule Them All");

        final double WIDTH = 500, HEIGHT = 600;

        //MenuBar creation station
        MenuBar menuBar = new MenuBar();

        //Menu Option Maker
        Menu fileMenu = new Menu("File");
        Menu exitMenu = new Menu("Exit");

        fileMenu.getItems().add(exitMenu);

        exitMenu.setOnAction(event -> { primaryStage.close();});

        menuBar.getMenus().add(fileMenu);

        //add our menu bar to borderPane
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
