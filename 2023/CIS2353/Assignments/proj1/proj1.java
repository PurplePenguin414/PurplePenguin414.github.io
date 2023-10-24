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
        Pizza pizza = new Pizza();

        if (toppings != null)
            pizza.addToppings(toppings);
        if (crust != null)
            pizza.setCrust(crust);
        if (size != null)
            pizza.setSize(size);

        // Display the order details using toString method
        System.out.println("\n\n----------------------");
        System.out.println("Your pizza order:");
        System.out.println(pizza.toString());

        scanner.close();
    }
}
