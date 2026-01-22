import java.io.*;
import java.util.Scanner;

public class Menu {

    public static void menuRunner() throws IOException {

        System.out.println("\nPress Enter to Start...");

        boolean continuing = true;
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);
        FileWriter wright = new FileWriter(fileName);
        int userInput;

        while(continuing) {
            System.out.println("""
                    Control Menu:\s
                    1: Write Binary File
                    2: Read Binary File
                    3: Delete Binary File
                    4: Write Random-Access File
                    5: Read Random-Access File
                    6: Delete Random-Access File
                    7: Exit Control Menu""");

            userInput = sc.nextInt();
            sc.nextLine();
            switch (userInput) {
                case 1:


                    // Gather User Input on Data to Write to File.
                    System.out.println("Input Text: ");
                    String[] names = sc.nextLine().split(",");

                    FileOutputStream fStream = new FileOutputStream("WriteUTF.dat");
                    DataOutputStream outStream = new DataOutputStream(fStream);

                    System.out.println("Writing Binary File...");

                    for (int i = 0; i < names.length; i++) {
                        outStream.writeUTF(names[i]);
                    }
                    System.out.println("File Written Successfully!");
                    outStream.close();

                    break;
                case 2:



                    break;
                case 3:



                    break;
                case 4:

                    System.out.println("Add New File Contents: ");
                    String phrase = sc.nextLine();
                    wright.write(phrase);
                    wright.close();

                    break;
                case 5:



                    break;
                case 6:

                    if(file.exists()){
                        System.out.println("File Exists. Delete? Y/N");
                        String delete = sc.nextLine();
                        deleteFile(delete, file);
                    }
                    else{System.out.println("File Does Not Exist, Please Create File First.");}

                    break;
                case 7:

                    System.out.println("Exiting...");
                    continuing = false;

                    break;
            }


        }

    }

    public static void deleteFile(String delete, File file){

        if(delete.contains("y") || delete.contains("Y")){
            if(file.delete()){
                System.out.println("File Removed");
            }

        }
        else{
            System.out.println("File Not Removed");
        }

    }
}

