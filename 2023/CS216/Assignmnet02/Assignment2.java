package CS216.Assignmnet02;
import java.util.Scanner;


public class Assignment2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter user " + (i+1) + " information:");
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Height (in): ");
            int height = scanner.nextInt();
            System.out.print("Weight: ");
            int weight = scanner.nextInt();
            System.out.print("Gender: ");
            String gender = scanner.next();
            System.out.print("Activity Type: ");
            String activityType = scanner.next();
            System.out.print("MPH: ");
            double mph = scanner.nextDouble();
            System.out.print("Minutes: ");
            int minutes = scanner.nextInt();
            System.out.println();

            users[i] = new User(age, height, weight, gender, activityType, mph, minutes);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("User " + (i+1) + " information:");
            users[i].printUser();
            System.out.println();
        }

        scanner.close();
    }
}
