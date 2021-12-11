/**
 * A container for a spice involved in a spice heist. From Arrakis in
 * origin, in my greedy knapsack for destination.
 */
public class MarcusSpice {
    private String name;
    private double price;
    private int quantity;

    // Constructor based on totalPrice as input
    public MarcusSpice(String name, double totalPrice, int quantity) {
        this.name = name;
        this.price = totalPrice / quantity;
        this.quantity = quantity;
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
}
