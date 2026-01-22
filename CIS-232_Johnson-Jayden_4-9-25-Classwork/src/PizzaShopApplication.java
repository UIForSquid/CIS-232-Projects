import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PizzaShopApplication extends Application {

    //fields
    CheckBox pepperoniCheckBox;
    CheckBox cheeseCheckBox;
    CheckBox extraCheeseCheckBox;
    CheckBox vegitableCheckBox;
    CheckBox pineappleCheckBox;

    ComboBox pizzaSize;
    TextField orderName;
    Label price;
    Label title;
    Label nameLabel;

    Slider tipSlider;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        //create CheckBoxes
        pepperoniCheckBox = new CheckBox("Cheese $1.00");
        cheeseCheckBox = new CheckBox("Cheese $1.50");
        extraCheeseCheckBox = new CheckBox("Cheese Cheese $2.00");
        vegitableCheckBox = new CheckBox("Cheese $3.00");
        pineappleCheckBox = new CheckBox("Not Cheese $5.00");

        //creates labels
        title = new Label("Not-a-Front Pizza");
        nameLabel = new Label("Customer Name");
        price = new Label("Total Price: $0.00");

        //gets customer name
        orderName = new TextField("Enter Name Here");

        //creates combo box
        pizzaSize = new ComboBox();
        pizzaSize.getItems().addAll("Small $7", "Medium $10", "Large $13");
        pizzaSize.setValue("Medium $10");

        //add a slider
        Label tip = new Label("Add Tip: ");
        tipSlider = new Slider(0, 50, 0);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setBlockIncrement(1);

        //add a button
        Button order = new Button("ORDER NOW");
        order.setOnAction(new TotalHandler());

        //IMAGE
        Image image = new Image("pizzaPicture.jpg");
        ImageView pizzaImage = new ImageView(image);
        pizzaImage.setFitHeight(100);

        //ENTER THE GRID!!
        GridPane pane = new GridPane();
        pane.add(pizzaImage, 0, 3);
        pane.add(nameLabel, 0, 1);
        pane.add(orderName, 1, 1);
        pane.add(pizzaSize, 2, 1);

        pane.add(tip, 0, 2);
        pane.add(tipSlider, 1, 2);
        //VBox for CheckBox
        VBox checkBoxes = new VBox(pepperoniCheckBox, cheeseCheckBox, extraCheeseCheckBox, vegitableCheckBox, pineappleCheckBox);
        pane.add(checkBoxes, 2, 2);

        pane.add(order, 1, 3);
        pane.add(price, 2, 3);

        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 20));

        Scene scene = new Scene(pane, 550, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Not-a-Front Pizza");
        primaryStage.show();

    }

    class TotalHandler implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent event) {
            double result = 0.0;
            String size = (String) pizzaSize.getValue();
            double tip = tipSlider.getValue();

            if(pepperoniCheckBox.isSelected()) {
                result += 1.0;
            }
            if(cheeseCheckBox.isSelected()) {
                result += 1.5;
            }
            if(extraCheeseCheckBox.isSelected()) {
                result += 2.0;
            }
            if(vegitableCheckBox.isSelected()) {
                result += 3.0;
            }
            if(pineappleCheckBox.isSelected()) {
                result += 5;
            }

            if(size == "Small $7") {
                result += 7;
            }
            else if(size == "Medium $10") {
                result += 10;
            }
            else if(size == "Large $13") {
                result += 13;
            }

            result += tip;

            price.setText("Total Price: $" + String.format("%.2f", result));

        }
    }

}
