import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MetricsConverter extends Application {

    private TextField fieldKilo;
    private Label labelTotal;

    RadioButton radioMiles, radioFeet, radioInches;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Metrics Converter");

        //text feild
        fieldKilo = new TextField();
        labelTotal = new Label("Enter Kilometers");

        //radio buttons
        radioMiles = new RadioButton("Convert to Miles");
        radioFeet = new RadioButton("Convert to Feet");
        radioInches = new RadioButton("Convert to Inches");

        //default selection
        radioMiles.setSelected(true);

        //toggle group
        ToggleGroup toggleGroup = new ToggleGroup();
        radioMiles.setToggleGroup(toggleGroup);
        radioFeet.setToggleGroup(toggleGroup);
        radioInches.setToggleGroup(toggleGroup);

        //button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(new ConvertHadler());

        //boxes and scene
        VBox vBoxOne = new VBox(10, labelTotal, fieldKilo, convertButton);
        vBoxOne.setAlignment(Pos.CENTER);

        VBox vBoxTwo = new VBox(10, radioMiles, radioFeet, radioInches);
        vBoxTwo.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(10, vBoxOne, vBoxTwo);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(hBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private class ConvertHadler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            final double MILES_CONVERSION = 0.6214;
            final double FEET_CONVERSION = 3281.0;
            final double INCHES_CONVERSION = 39370.0;

            String type = "ERROR";
            double total = 0;
            double kilometers = Double.parseDouble(fieldKilo.getText());

            if (radioMiles.isSelected()) {
                total = MILES_CONVERSION * kilometers;
                type = " miles";
            }
            else if (radioFeet.isSelected()) {
                total = FEET_CONVERSION * kilometers;
                type = " feet";
            }
            else if (radioInches.isSelected()) {
                total = INCHES_CONVERSION * kilometers;
                type = " inches";
            }

            labelTotal.setText("Your Conversion is:  " + String.format("%.2f", total) + type);

        }
    }

}
