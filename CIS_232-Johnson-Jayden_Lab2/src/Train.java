import java.util.Arrays;

public class Train extends Vehicle {

    protected boolean isDiesel;
    protected boolean isBullet;
    protected int num_of_cars;
    protected final String[] passengers = new String[50];

    public Train(){

        xValue = 0;
        yValue = 0;
        length = 18;
        width = 6;
        speed = 3;
        direction = 'e';
        super.passengers = passengers;

    }


    public void unloadTrain() {
        Arrays.fill(passengers, null);
        numPassengers = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " isDiesel = " + isDiesel + " num_of_cars = " + num_of_cars;
    }
}
