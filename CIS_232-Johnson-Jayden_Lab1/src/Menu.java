import java.util.Arrays;

public class Menu extends Spawner {

    protected boolean controlling = false;
    protected boolean continuing = true;
    protected int userInput;
    public String[] people;

    public void SpawnMenu() {

        System.out.println("Welcome to the program, please decide on an action!");

        while (continuing) {
            //Symbols are to help know which one is on and which is off, | = on and - = off

            // - - -
            if (!carSpawned && !boatSpawned && !trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Spawn Car
                        
                        2: Spawn Boat
                        
                        3: Spawn Train
                        
                        4: Exit""");

            }
            // | - -
            else if (carSpawned && !boatSpawned && !trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Control Car
                        
                        2: Spawn Boat
                        
                        3: Spawn Train
                        
                        4: Exit""");

            }
            // - | -
            else if (!carSpawned && boatSpawned && !trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Spawn Car
                        
                        2: Control Boat
                        
                        3: Spawn Train
                        
                        4: Exit""");

            }
            // - - |
            else if (!carSpawned && !boatSpawned && trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Spawn Car
                        
                        2: Spawn Boat
                        
                        3: Control Train
                        
                        4: Exit""");

            }
            // | | -
            else if (carSpawned && boatSpawned && !trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Control Car
                        
                        2: Control Boat
                        
                        3: Spawn Train
                        
                        4: Exit""");

            }
            // - | |
            else if (!carSpawned && boatSpawned && trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Spawn Car
                        
                        2: Control Boat
                        
                        3: Control Train
                        
                        4: Exit""");

            }
            // | - |
            else if (carSpawned && !boatSpawned && trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Control Car
                        
                        2: Spawn Boat
                        
                        3: Control Train
                        
                        4: Exit""");

            }
            // | | |
            else if (carSpawned && boatSpawned && trainSpawned) {

                System.out.println("""

                        Select what you would like to spawn:
                        
                        1: Control Car
                        
                        2: Control Boat
                        
                        3: Control Train
                        
                        4: Exit""");

            }
            //This is meant to be unreachable, and should never be needed.
            else {
                System.out.println("Something went very wrong somewhere!! Code: 1");
            }

            userInput = scanner.nextInt();
            scanner.nextLine();

            //Takes user input to determine what to spawn.
            switch (userInput) {
                //Spawn Car
                case 1:
                    if(!carSpawned) {

                        super.spawnCar();
                    }
                    else {
                        controlling = true;
                        while (controlling) {
                            if (car.numPassengers == 0) {
                                System.out.println("Please enter names of people to add to your car, separate names with commas:\n");
                                people = scanner.nextLine().split(",");

                                car.loadPassengers(people);

                            } else {
                                System.out.println("""
                                        
                                        Select what you would like to do with your car:
                                        
                                        1: Drive Car
                                        2: Stop Car
                                        3: Add Passengers
                                        4: Remove Passengers
                                        5: Car Stats
                                        6: Delete Car
                                        7: Exit Controller""");
                                userInput = scanner.nextInt();
                                scanner.nextLine();

                                switch (userInput) {
                                    case 1:
                                        car.drive();
                                        break;

                                    case 2:
                                        car.brake();
                                        break;

                                    case 3:
                                        car.loadPassengers(people);
                                        break;

                                    case 4:
                                        car.unloadCar();
                                        break;

                                    case 5:
                                        System.out.println(car.toString());
                                        break;

                                    case 6:
                                        carSpawned = false;
                                        Arrays.fill(car.passengers, null);
                                        break;

                                    case 7:
                                        controlling = false;
                                        break;

                                    default:
                                        System.out.println("Select a valid option!");

                                }
                            }
                        }
                    }
                    break;

                //Spawn Boat
                case 2:
                    if(!boatSpawned) {

                        super.spawnBoat();

                    }
                    else {
                        controlling = true;
                        while (controlling) {
                            if (boat.numPassengers == 0) {
                                System.out.println("Please enter names of people to add to your boat, separate names with commas:\n");
                                people = scanner.nextLine().split(",");

                                boat.loadPassengers(people);
                            } else {
                                System.out.println("""
                                        
                                        Select what you would like to do with your boat:
                                        
                                        1: Sail your Boat
                                        2: Stop Boat
                                        3: Add Passengers
                                        4: Remove Passengers
                                        5: Boat Stats
                                        6: Delete Boat
                                        7: Exit Controller""");
                                userInput = scanner.nextInt();
                                scanner.nextLine();

                                switch (userInput) {
                                    case 1:
                                        boat.drive();
                                        break;

                                    case 2:
                                        boat.brake();
                                        break;

                                    case 3:
                                        boat.loadPassengers(people);
                                        break;

                                    case 4:
                                        boat.unloadBoat();
                                        break;

                                    case 5:
                                        System.out.println(boat.toString());
                                        break;

                                    case 6:
                                        boatSpawned = false;
                                        Arrays.fill(boat.passengers, null);
                                        break;

                                    case 7:
                                        controlling = false;
                                        break;

                                    default:
                                        System.out.println("Select a valid option!");

                                }
                            }
                        }
                    }
                    break;

                //Spawn Train
                case 3:
                    if(!trainSpawned) {

                        super.spawnTrain();

                    }
                    else {
                        controlling = true;
                        while (controlling) {
                            System.out.println("""
                                    
                                    Select what you would like to do with your train:
                                    
                                    1: Drive Train
                                    2: Stop Train
                                    3: Pick up Passengers from Station
                                    4: Drop off Passengers at Station
                                    5: Train Stats
                                    5: Delete Train
                                    6: Exit Controller""");
                            userInput = scanner.nextInt();
                            scanner.nextLine();

                            switch (userInput) {
                                case 1:
                                    train.drive();
                                    break;

                                case 2:
                                    train.brake();
                                    break;

                                case 3:
                                    train.loadPassengers(people);
                                    break;

                                case 4:
                                    train.unloadTrain();
                                    break;

                                case 5:
                                    System.out.println(train.toString());
                                    break;

                                case 6:
                                    trainSpawned = false;
                                    Arrays.fill(train.passengers, null);
                                    break;

                                case 7:
                                    controlling = false;
                                    break;

                                default:
                                    System.out.println("Select a valid option!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...\n");
                    continuing = false;

                    break;

                default:
                    System.out.println("Invalid input. Please try again...\n");

            }

        }
    }
}
