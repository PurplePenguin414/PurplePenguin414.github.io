import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public double calculateTotalPrice() {
        // Define prices for crust, toppings, and size
        double crustPrice = 0.0;
        double toppingPrice = 1.0; // Price per topping
        double sizePrice = 0.0;

        switch (crust) {
            case "Thin Crust":
                crustPrice = 5.0;
                break;
            case "Thick Crust":
                crustPrice = 6.0;
                break;
            case "Stuffed Crust":
                crustPrice = 7.0;
                break;
        }

        switch (size) {
            case "Small":
                sizePrice = 8.0;
                break;
            case "Medium":
                sizePrice = 10.0;
                break;
            case "Large":
                sizePrice = 12.0;
                break;
        }

        double totalToppingsPrice = toppings.size() * toppingPrice;

        return crustPrice + sizePrice + totalToppingsPrice;
    }
}

public class PizzaOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define crust options
        String[] crustOptions = {"Thin Crust", "Thick Crust", "Stuffed Crust"};

        // Define toppings options
        String[] toppingsOptions = {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon"};

        // Define size options
        String[] sizeOptions = {"Small", "Medium", "Large"};

        // Welcome message
        System.out.println("Welcome to the Pizza Ordering System!");

        // Select crust
        System.out.println("Choose your crust:");
        for (int i = 0; i < crustOptions.length; i++) {
            System.out.println((i + 1) + ". " + crustOptions[i]);
        }
        int crustChoice = scanner.nextInt();
        String selectedCrust = crustOptions[crustChoice - 1];

        // Select toppings
        List<Topping> selectedToppings = new ArrayList<>();
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
        int sizeChoice = scanner.nextInt();
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
        System.out.println("Total Price: $" + pizza.calculateTotalPrice());

        // Close the scanner
        scanner.close();
    }
}
