//This Program was made by Jayden Johnson on 4/11/2025.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//THE PROGRAM LIVES!! I think I'll name it Darrel.
public class ProblemOne extends Application {

    //create ComboBoxes
    ComboBox medicalPlan;
    ComboBox dentalPlan;

    //create labels
    Label medicalLabel = new Label("Please select a medical plan.  ");
    Label dentalLabel = new Label("Please select a dental plan.  ");
    Label planTotal = new Label("Total Plan Price: $--.--");

    //Create some buttons
    Button oneMonthTotal = new Button("Once Month Price");
    Button sixMonthTotal = new Button("Six Month Price");

    //set plan prices
    double goldMedPlanPrice = 321.98;
    double silverMedPlanPrice = 210.37;
    double bronzeMedPlanPrice = 104.10;
    double goldDentPlanPrice = 17.80;
    double silverDentPlanPrice = 11.45;
    double bronzeDentalPlanPrice = 6.22;

    public static void main(String[] args) {

        //I wonder where we're going for lunch today?
        launch(args);

    }

    public void start(Stage primaryStage) {

        //A Combination of Boxes
        medicalPlan = new ComboBox();
        medicalPlan.getItems().addAll("Gold Medical Plan", "Silver Medical Plan", "Bronze Medical Plan");
        medicalPlan.setValue("Gold Medical Plan");

        dentalPlan = new ComboBox();
        dentalPlan.getItems().addAll("Gold Dental Plan", "Silver Dental Plan", "Bronze Dental Plan");
        dentalPlan.setValue("Gold Dental Plan");

        //Buttons... they do things now.
        oneMonthTotal.setOnAction(new TotalHandler());
        sixMonthTotal.setOnAction(new SixMonthHandler());

        //Yep, this is where the grid is made. It's probably here to help keep things organized, but who knows.
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(20);

        //This looks like column 0
        pane.add(medicalLabel, 0, 0);
        pane.add(medicalPlan, 0, 1);
        pane.add(oneMonthTotal, 0, 2);
        pane.add(planTotal, 0, 3);

        //And I guess that makes this column 1
        pane.add(dentalLabel, 1, 0);
        pane.add(dentalPlan, 1, 1);
        pane.add(sixMonthTotal, 1, 2);


        //Create da scene
        Scene scene = new Scene(pane, 1910, 1070);
        //STYLE TIME!! IMA MAKE IT SO PERTY
        scene.getStylesheets().add("Stylesheet.css");

        //Now we can look at Darrel's new style :)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Plans");
        primaryStage.show();

    }

    class TotalHandler implements EventHandler<ActionEvent> {

        //Math Time. Looks like we're adding plan prices together here.
        public void handle(ActionEvent event) {
            double total = 0;
            String medPlan = (String) medicalPlan.getValue();
            String dentPlan = (String) dentalPlan.getValue();

            if(medPlan == "Gold Medical Plan") {
                total += goldMedPlanPrice;
            }
            else if(medPlan == "Silver Medical Plan"){
                total += silverMedPlanPrice;
            }
            else if(medPlan == "Bronze Medical Plan"){
                total += bronzeMedPlanPrice;
            }

            if(dentPlan == "Gold Dental Plan"){
                total += goldDentPlanPrice;
            }
            else if(dentPlan == "Silver Dental Plan"){
                total += silverDentPlanPrice;
            }
            else if(dentPlan == "Bronze Dental Plan"){
                total += bronzeDentalPlanPrice;
            }

            planTotal.setText("Your total for one month is $" + String.format("%.2f", total));

        }

    }

    //And here we multiply by 6 and add a 10% discount.
    class SixMonthHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            double total = 0;

            String medPlan = (String) medicalPlan.getValue();
            String dentPlan = (String) dentalPlan.getValue();

            if(medPlan == "Gold Medical Plan") {
                total += goldMedPlanPrice;
            }
            else if(medPlan == "Silver Medical Plan"){
                total += silverMedPlanPrice;
            }
            else if(medPlan == "Bronze Medical Plan"){
                total += bronzeMedPlanPrice;
            }

            if(dentPlan == "Gold Dental Plan"){
                total += goldDentPlanPrice;
            }
            else if(dentPlan == "Silver Dental Plan"){
                total += silverDentPlanPrice;
            }
            else if(dentPlan == "Bronze Dental Plan"){
                total += bronzeDentalPlanPrice;
            }

            total *= 6;
            double discount = (total)*0.1;
            total -= discount;

            planTotal.setText("Your total for one month is $" + String.format("%.2f", total));

        }

    }

}
