/**
 * A container for a spice involved in a spice heist. From Arrakis in
 * origin, in my greedy knapsack for destination.
 */
public class MarcusSpice {
    private String name;
    private double price;
    private int quantity;
    private int quantityLeft;

    public MarcusSpice() {
        this.name = null;
        this.price = 0;
        this.quantity = 0;
        this.quantityLeft = 0;
    }

    // Constructor based on totalPrice as input
    public MarcusSpice(String name, double totalPrice, int quantity) {
        this.name = name;
        this.price = totalPrice / quantity;
        this.quantity = quantity;
        this.quantityLeft = quantity;
    }

    // Setters and getters for private fields
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        if (quantityLeft != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void resetQuantity() {
        this.quantityLeft = this.quantity;
    }

    public void putInKnapsack() {
        if (this.quantityLeft != 0){
            this.quantityLeft--;
        } else {
            System.out.println("Oops! 0 remaining.");
        }
    }
}
