import java.util.Scanner;

public class Boat extends Vehicle {

    protected String owner;
    protected boolean isSailboat;
    protected boolean isCoastGuard;
    protected final String[] passengers = new String[8];

    public Boat() {

        xValue = 0;
        yValue = 0;
        length = 25;
        width = 8;
        speed = 1;
        direction = 'w';
        super.passengers = passengers;

    }

    //Used when you want to create different types of cars.
    public void variantCars(){

        if(isSailboat){
            length = 20;
            width = 9;
        }
        if(isCoastGuard){
            speed = 2;
            length = 30;
            width = 10;
        }

    }

    public void unloadBoat(){

        boolean numWrong = true;

        while (numWrong) {
            //Gets how many to remove
            System.out.println("How many passengers do you want to unload?");
            int numUnload = scanner.nextInt();

            //Checks to make sure the number is within the boat's carry limit.
            if(numUnload > 8 || numUnload < 0) {
                System.out.println("Please enter a number valid (0-8)");
            } else {
                numWrong = false;
                super.unloadPassengers(numUnload);
            }
        }

    }

    @Override
    public String toString() {
        return super.toString() + " Owner" + owner + ", isSailBoat" + isSailboat + ", isCoastGuard" + isCoastGuard;
    }
}
