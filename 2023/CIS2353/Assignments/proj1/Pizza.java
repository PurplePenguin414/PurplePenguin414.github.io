import java.util.*;
public class Pizza implements Comparable<Pizza>{
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
        if (!toppings.equals("empty")) {
            this.toppings += "\n " + top;
        } else {
            this.toppings = top;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pizza otherPizza = (Pizza) obj;

        // Compare the number of toppings
        int thisToppingsCount = this.toppings.split(", ").length;
        int otherToppingsCount = otherPizza.toppings.split(", ").length;

        return thisToppingsCount == otherToppingsCount;
    }




    @Override
    public int compareTo(Pizza otherPizza) {
        // Compare the number of toppings first
        int toppingsComparison = this.toppings.split(", ").length - otherPizza.toppings.split(", ").length;
        if (toppingsComparison != 0) {
            return toppingsComparison;
        }

        // If they have the same number of toppings, compare the crusts
        int crustComparison = getCrustRank(this.crust) - getCrustRank(otherPizza.crust);
        if (crustComparison > 1){
            crustComparison = 1;
        }

        return crustComparison;
    }

    // Helper method to assign a rank to crusts
    private int getCrustRank(String crust) {
        switch (crust) {
            case "Cheese":
                return 5;
            case "GarlicButter":
                return 4;
            case "Garlic":
                return 3;
            case "Butter":
                return 2;
            case "Plain":
                return 1;
            default:
                return 0; // Return 0 for unknown crusts
        }
    }




    @Override
    public String toString() {
        String top = "";
        String[] topping = toppings.split(", ");
        for (int i = 0; i < topping.length; i++){
            top += ("\n" + topping[i]);
        }
        if (crust == ""){
            this.crust = "Plain";
        }else;
        return "This pizza has a " + crust + " crust and the following toppings:" + " " + top;
    }
}
