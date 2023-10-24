public class PizzaDemo {
    public static void main(String[] args) {
        // Create some Pizza objects
        Pizza pizza1 = new Pizza("Cheese", "Onions, Pepperoni", "Large");
        Pizza pizza1a = new Pizza("Cheese", "Onions, Pepperoni", "Large");
        Pizza pizza2 = new Pizza("GarlicButter", "Ham, Pineapple", "Medium");
        Pizza pizza3 = new Pizza("GarlicButter", "Pepperoni, Cheese", "Small");
        Pizza pizza4 = new Pizza("Cheese", "Pepperoni", "Large");

        // Test the equals method
        System.out.println(pizza1a.equals(pizza1));
        System.out.println(pizza1.equals(pizza2));
        System.out.println(pizza1.equals(pizza4));
        System.out.println(pizza2.equals(pizza3));

        // Test the compareTo method
        int comparison1ato2 = pizza1a.compareTo(pizza1);
        int comparison1to2 = pizza1.compareTo(pizza2);
        int comparison2to1 = pizza2.compareTo(pizza1);
        int comparison1to4 = pizza1.compareTo(pizza4);
        int comparison4to3 = pizza4.compareTo(pizza3);
        int comparison2to3 = pizza2.compareTo(pizza3);


        System.out.println("Comparison of Pizza 1a to Pizza 1: " + comparison1ato2);
        System.out.println("Comparison of Pizza 1 to Pizza 2: " + comparison1to2);
        System.out.println("Comparison of Pizza 2 to Pizza 1: " + comparison2to1);
        System.out.println("Comparison of Pizza 1 to Pizza 4: " + comparison1to4);
        System.out.println("Comparison of Pizza 4 to Pizza 3: " + comparison4to3);
        System.out.println("Comparison of Pizza 2 to Pizza 3: " + comparison2to3);
    }
}
