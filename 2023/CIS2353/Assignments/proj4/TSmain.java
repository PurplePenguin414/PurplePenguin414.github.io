
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Megan Gibbs
// CIS 2353
// Fall 2023
// Prof. John P. Baugh


class TSmain {

    //Create a scanner
    static Scanner sn = new Scanner(System.in);
        public static void main(String[] args) {
            //Create the instance
            TriageSimulator triageSimulator = new TriageSimulator();
    
            System.out.println("Reading File......");

            // Specify the path to your file
            String filePath = "2023/CIS2353/Assignments/proj4/test.txt";

            //Read file
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    triageSimulator.add(line);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
                e.printStackTrace();
            }

            //Print queue
            while (!triageSimulator.isEmpty()) {
                System.out.println("Next patient: " + triageSimulator.remove());
            }

            while (!triageSimulator.isEmpty()) {
                System.out.println("Next patient: " + triageSimulator.remove());
            }
            
            //Read File Again
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    triageSimulator.add(line);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
                e.printStackTrace();
            }

            //Prompt user
            System.out.println("To remove a paitent enter R:");

            String user = sn.next();
            
            String O1 = "A";
            String O2 = "R";
            if (user.contains(O1)){
                System.out.println("Enter the Paitent to add: ");
                String line1 = sn.nextLine();
                triageSimulator.add(line1);
            } else if (user.contains(O2)){
                System.out.println("You removed the most critical paitent: " + triageSimulator.remove());
            }else;


            //Print the users left
            while (!triageSimulator.isEmpty()) {
                System.out.println("Next patient: " + triageSimulator.remove());
            }

            while (!triageSimulator.isEmpty()) {
                System.out.println("Next patient: " + triageSimulator.remove());
            }
        
        }
}
