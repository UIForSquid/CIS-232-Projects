import java.util.Scanner;

public class Vehicle {

    public int counter = 0;

    public String vehicleType;
    public int xValue;
    public int yValue;
    public char direction;
    protected double speed;
    protected int length;
    protected int width;
    protected boolean stop = true;
    protected int turnTimer = 0;
    protected double gasLevel = 100;
    protected String[] passengers = new String[0];
    protected int numPassengers = 0;
    protected Scanner scanner = new Scanner(System.in);

    public Vehicle() {



    }

    public void brake(){

        speed = 0;
        stop = true;

    }

    public void drive()
    {
        if(gasLevel == 0)
        {
            stop = true;
        } else {stop = false;}

        if(!stop) {
            switch (direction) {
                case 'n':
                    yValue -= speed;
                    gasLevel --;
                    System.out.println("You are is now at: " + yValue + " " + xValue + ".");
                    break;

                case 's':
                    yValue += speed;
                    gasLevel --;
                    System.out.println("You are is now at: " + yValue + " " + xValue + ".");
                    break;

                case 'e':
                    xValue += speed;
                    gasLevel --;
                    System.out.println("You are is now at: " + yValue + " " + xValue + ".");
                    break;

                case 'w':
                    xValue -= speed;
                    gasLevel --;
                    System.out.println("You are is now at: " + yValue + " " + xValue + ".");
                    break;
            }
        }

    }

    public void loadPassengers(String[] people) {

        counter = 0;

        if (stop) {
            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] == null) {
                    if (counter != people.length) {
                        passengers[i] = people[counter];
                        counter++;
                        numPassengers++;
                    }
                }
            }
        }
        else{

            System.out.println("You must stop to unload Passengers");

        }
    }

    protected void unloadPassengers(int numUnload) {

        counter = 0;

        //Does the Removing if the Vehicle is stopped.
        if(stop) {
            for (int i = 1; i < passengers.length; i++) {
                //Checks if only Driver is left in car
                if(numPassengers != 1) {
                    //removes passengers before Driver
                    if (passengers[i] != null) {
                        if (counter != numUnload) {
                            passengers[i] = null;
                            counter++;
                            numPassengers--;
                        }
                    }
                }
                //Removes Driver
                else if(passengers[0] != null && counter != numUnload)
                {
                    passengers[0] = null;
                    counter++;
                    numPassengers--;
                }

            }
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {

                System.out.println(passengers[i]);

            }
        }
        return "Speed: " + speed + " Length: " + length + " Width: " + width + " Direction: " + direction;
    }
}
