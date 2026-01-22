//This Program was made by Jayden Johnson on 4/11/2025.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProblemTwo extends Application {

    Label labelNights = new Label("How many nights will you be staying?");
    Label labelRoom = new Label("Select room size");
    Label labelAddon = new Label("Select additional items");
    Label labelTotal = new Label("Total Cost: $###.##");

    TextField fieldNights = new TextField("Number of Nights");

    ComboBox comboRoom;

    //Gift=$10 Snack=$25 Tour=$45 Romance=$50
    RadioButton radioGiftBag, radioSnack, radioTour, radioRomance;

    Button buttonTotal;


    public static void main(String[] args) {

        launch(args);

    }

    public void start(Stage primaryStage) {

        comboRoom = new ComboBox();
        comboRoom.getItems().addAll("King Size Room $245", "Queen Size Room $170");
        comboRoom.setValue("King Size Room $245");

        radioGiftBag = new RadioButton("Gift Bag $10");
        radioSnack = new RadioButton("Snack $25");
        radioTour = new RadioButton("Tour $45");
        radioRomance = new RadioButton("Romance $50");

        buttonTotal = new Button("Total");
        buttonTotal.setOnAction(new TotalHandler());


        //Create and set up GridPane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(25);
        pane.setVgap(25);

        //VBox creation
        VBox vbox = new VBox(radioGiftBag, radioSnack, radioTour, radioRomance);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));


        //Column 0
        pane.add(labelNights, 0, 0);
        pane.add(fieldNights, 0, 1);

        //Column 1
        pane.add(labelRoom, 1, 0);
        pane.add(comboRoom, 1, 1);

        //Column 2
        pane.add(labelAddon, 2, 0);
        pane.add(vbox, 2, 1);

        //Column 3
        pane.add(buttonTotal, 3, 0);
        pane.add(labelTotal, 3, 1);

        //Create the scene
        Scene scene = new Scene(pane, 1910, 1070);
        scene.getStylesheets().add("Stylesheet2.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Plans");
        primaryStage.show();

    }

    class TotalHandler implements EventHandler<ActionEvent> {

        //Math Time. Looks like we're adding plan prices together here.
        public void handle(ActionEvent event) {
            double total = 0;
            String room = (String) comboRoom.getValue();
            Integer nights = Integer.parseInt(fieldNights.getText());
            RadioButton giftBag = radioGiftBag;
            RadioButton snack = radioSnack;
            RadioButton tour = radioTour;
            RadioButton romance = radioRomance;

            if(room.equals("King Size Room $245")) {
                total += 245 * nights;
            }
            else if(room.equals("Queen Size Room $170")) {
                total += 170 * nights;
            }

            if(giftBag.isSelected()) {
                total += 10;
            }
            if(snack.isSelected()) {
                total += 25;
            }
            if(tour.isSelected()) {
                total += 45;
            }
            if(romance.isSelected()) {
                total += 50;
            }

            labelTotal.setText("Your total for " + nights + " is: $" + String.format("%.2f", total));

        }

    }

}