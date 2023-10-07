import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PRoject1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define crust options
        String[] crustOptions = {"Plain", "Butter", "Garlic", "GarlicButter" , "Cheese"};
        int crustChoice;

        // Define toppings options
        String[] toppingsOptions = { "Cheese", "Onions", "Green Pepper", "Ham" , "Pineapple" , "Pepperoni" , "Ground Beef" , "Italian Sausage" , "Anchovies"};
        ArrayList<String> selectedToppings = new ArrayList<>();

        // Define size options
        String[] sizeOptions = {"Small", "Medium", "Large", "XLarge", "XXLarge", "Party"};
        int sizeChoice;
        
        // Welcome message
        System.out.println("Welcome to the Pizza Ordering System!");

        // Select crust
        System.out.println("Choose your crust:");
        for (int i = 0; i < crustOptions.length; i++) {
            System.out.println((i + 1) + ". " + crustOptions[i]);
        }
        crustChoice = scanner.nextInt();
        String selectedCrust = crustOptions[crustChoice - 1];

        // Select toppings
        System.out.println("Choose your toppings (enter 0 when done):");
        for (int i = 0; i < toppingsOptions.length; i++) {
            System.out.println((i + 1) + ". " + toppingsOptions[i]);
        }
        int toppingChoice;
        while (true) {
            toppingChoice = scanner.nextInt();
            if (toppingChoice == 0) {
                break;
            }
            if (toppingChoice >= 1 && toppingChoice <= toppingsOptions.length) {
                selectedToppings.add(new Topping(toppingsOptions[toppingChoice - 1]));
            } else {
                System.out.println("Invalid topping choice. Please try again.");
            }
        }

        // Select size
        System.out.println("Choose your pizza size:");
        for (int i = 0; i < sizeOptions.length; i++) {
            System.out.println((i + 1) + ". " + sizeOptions[i]);
        }
        sizeChoice = scanner.nextInt();
        String selectedSize = sizeOptions[sizeChoice - 1];

        // Create a pizza object
        Pizza pizza = new Pizza(selectedCrust, selectedToppings, selectedSize);

        // Calculate and display the order summary
        System.out.println("\nOrder Summary:");
        System.out.println("Crust: " + pizza.getCrust());
        List<Topping> toppingsList = pizza.getToppings();
        if (!toppingsList.isEmpty()) {
            System.out.print("Toppings: ");
            for (Topping topping : toppingsList) {
                System.out.print(topping.getName() + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Toppings: None");
        }
        System.out.println("Size: " + pizza.getSize());


        // Close the scanner
        scanner.close();
    }
}
class Pizza {
    private String crust;
    private List<Topping> toppings;
    private String size;

    public Pizza(String crust, List<Topping> toppings, String size) {
        this.crust = crust;
        this.toppings = toppings;
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    // Return object contents to string object
    public String toString()
   {
      String outString  = "This pizza has a" + Crust + "crust and the following toppings:" + "\n" +
                          "Toppings: " + selectedToppings.toString() + "\n";
      return outString;
   }
    
    }
    

class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}



