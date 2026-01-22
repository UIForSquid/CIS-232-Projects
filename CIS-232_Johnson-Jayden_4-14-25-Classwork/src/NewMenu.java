import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewMenu extends Application {

    private MenuBar menuBar;
    private Menu fileMenu;
    private Menu textMenu;
    private MenuItem exitMenuItem;
    private RadioMenuItem blackItem, whiteItem, redItem, greenItem, blueItem;
    private CheckMenuItem visibleItem;
    private Label label;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("New Menu");

        final double WIDTH = 600, HEIGHT = 500;

        //Label Maker
        label = new Label("LABEL LABEL LABEL LABEL LABEL LABEL LABEL LABEL");

        //Menu Creation
        menuBar = new MenuBar();

        buildFileMenu(primaryStage);
        buildTextMenu();

        menuBar.getMenus().addAll(fileMenu, textMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: gray;");
        gridPane.add(label, 0, 0);

        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void buildFileMenu(Stage primaryStage) {

        fileMenu = new Menu("File");
        exitMenuItem = new MenuItem("Exit");
        //exit action
        exitMenuItem.setOnAction(e -> primaryStage.close());

        fileMenu.getItems().add(exitMenuItem);

    }
    private void buildTextMenu() {

        textMenu = new Menu("Text");

        blackItem = new RadioMenuItem("Black");
        whiteItem = new RadioMenuItem("White");
        redItem = new RadioMenuItem("Red");
        greenItem = new RadioMenuItem("Green");
        blueItem = new RadioMenuItem("Blue");

        visibleItem = new CheckMenuItem("Visible");

        ToggleGroup group = new ToggleGroup();
        blackItem.setToggleGroup(group);
        whiteItem.setToggleGroup(group);
        redItem.setToggleGroup(group);
        greenItem.setToggleGroup(group);
        blueItem.setToggleGroup(group);

        blackItem.setOnAction(e -> {label.setStyle("-fx-text-fill: black;");});
        whiteItem.setOnAction(e -> {label.setStyle("-fx-text-fill: white;");});
        redItem.setOnAction(e -> {label.setStyle("-fx-text-fill: red;");});
        greenItem.setOnAction(e -> {label.setStyle("-fx-text-fill: green;");});
        blueItem.setOnAction(e -> {label.setStyle("-fx-text-fill: blue;");});

        visibleItem.setOnAction(e -> {
            if(label.isVisible()){
                label.setVisible(false);
            } else {label.setVisible(true);}
        });

        textMenu.getItems().addAll(blackItem, whiteItem, redItem, greenItem, blueItem);
        textMenu.getItems().addAll(new SeparatorMenuItem(), visibleItem);
    }
}
