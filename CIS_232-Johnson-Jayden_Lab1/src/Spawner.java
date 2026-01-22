import java.util.Scanner;

public class Spawner {

    protected boolean carSpawned = false;
    protected boolean boatSpawned = false;
    protected boolean trainSpawned = false;
    protected Scanner scanner = new Scanner(System.in);
    Car car = new Car();
    Boat boat = new Boat();
    Train train = new Train();

    public void spawnCar() {

        System.out.println("Spawning a car...\n\n");

        System.out.println("""
                Use a number to select the type of the car:

                1: Normal Car

                2: Police Car

                3: Bus""");
        int carInput = scanner.nextInt();
        scanner.nextLine();

        //Uses user input to determine what type of car to spawn
        switch (carInput) {
            //Normal Car
            case 1:
                car.isPolice = false;
                car.isBus = false;

                car.setCar();

                carSpawned = true;
                break;

            //Police Car
            case 2:
                car.isPolice = true;
                car.isBus = false;

                car.setCar();

                carSpawned = true;
                break;

            //Bus
            case 3:
                car.isPolice = false;
                car.isBus = true;

                car.setCar();

                carSpawned = true;
                break;

            default:
                System.out.println("Invalid input!");
        }
    }
    public void spawnBoat() {

        //Spawn Boat
        System.out.println("Spawning a boat...\n\n");

        System.out.println("""
               Use a number to select the type of the boat:

               1: Normal Boat

               2: Coast Guard

               3: Sailboat""");
        int boatInput = scanner.nextInt();
        scanner.nextLine();

        //Uses user input to determine what type of boat to spawn
        switch (boatInput) {
            //Normal boat
            case 1:
                boat.isSailboat = false;
                boat.isCoastGuard = false;

                boatSpawned = true;
                break;

            //Coast Guard
            case 2:
                boat.isSailboat = false;
                boat.isCoastGuard = true;

                boatSpawned = true;
                break;

            //Sailboat
            case 3:
                boat.isSailboat = true;
                boat.isCoastGuard = false;

                boatSpawned = true;
                break;

            default:
                System.out.println("Invalid input!");
        }


    }
    public void spawnTrain() {

        //Spawn Train
        System.out.println("Spawning a train...\n\n");

        System.out.println("""
               Use a number to select the type of the car:

               1: Normal Train

               2: Diesel Train

               3: Bullet Train""");
        int trainInput = scanner.nextInt();
        scanner.nextLine();

        //Uses user input to determine what type of train to spawn
        switch (trainInput) {
            //Normal Train
            case 1:
                trainSpawned = true;
                break;

            //Diesel
            case 2:
                train.isDiesel = true;
                trainSpawned = true;
                break;

            //Bullet
            case 3:
                train.isBullet = true;
                trainSpawned = true;
                break;

            default:
                System.out.println("Invalid input!");
        }

    }

}
