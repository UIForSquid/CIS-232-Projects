public class Car extends Vehicle {

    public String plateNumber;
    protected String owner;
    protected boolean isPolice;
    protected boolean isBus;
    protected String[] passengers = new String[5];


    //Sets values for future use
    public void carDefaults(){

        xValue = 0;
        yValue = 0;
        length = 12;
        width = 5;
        speed = 1;
        direction = 's';
        super.passengers = passengers;

    }

    //Used when you want to create different types of cars.
    public void setCar(){

        if(isPolice){
            speed = 2;
        }
        if(isBus){
            width = 6;
            length = 15;
            passengers = new String[10];
        }
        else{carDefaults();}

    }

    //Removes people from the Car one person at a time.
    public void unloadCar() {

        boolean numWrong = true;

        while (numWrong) {
            //Gets how many to remove
            System.out.println("How many passengers do you want to unload?");
            int numUnload = scanner.nextInt();

            //Checks to make sure the number is within the car's carry limit.
            if(isBus){
                if(numUnload > 10 || numUnload < 0){
                    System.out.println("Please enter a valid number (0-10)");
                }
            }
            else if(numUnload > 5 || numUnload < 0) {
                System.out.println("Please enter a number valid (0-5)");
            } else {

                numWrong = false;
                super.unloadPassengers(numUnload);

            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " plateNumber: " + plateNumber + ", Owner: " + owner + ", isPolice: " + isPolice + ", isBus: " + isBus;
    }
}
