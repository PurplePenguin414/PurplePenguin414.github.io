import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class proj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Order System!");
        System.out.println("Available crust options: Plain, Butter, Garlic, GarlicButter, Cheese");
        System.out.println("Available topping options: Cheese, Onions, Green Pepper, Ham, Pineapple, Pepperoni, Ground Beef, Italian Sausage, Anchovies");
        System.out.println("Available size options: Small, Medium, Large, XLarge, XXLarge, Party");

        System.out.print("Enter your desired crust: ");
        String crust = scanner.nextLine();

        System.out.print("Enter your desired toppings (comma-separated): ");
        String toppings = scanner.nextLine();

        System.out.print("Enter your desired size: ");
        String size = scanner.nextLine();

        // Create a Pizza object with user inputs
        Pizza pizza = new Pizza(crust, toppings, size);

        // Display the order details
        System.out.println("Your pizza order:");
        System.out.println(pizza);

        scanner.close();
    }
}



class Pizza {
    private String crust;
    private String toppings;
    private String size;

    public Pizza() {
        this.crust = "Plain";
        this.toppings = "empty";
        this.size = "Small";
    }

    public Pizza(String crust, String toppings, String size) {
        this.crust = crust;
        this.toppings = toppings;
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public String getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addToppings(String top) {
        this.toppings += " ," + top;
    }

    @Override
    public String toString() {
        return "Pizza [crust=" + crust + ", toppings=" + toppings + ", size=" + size + "]";
    }
}