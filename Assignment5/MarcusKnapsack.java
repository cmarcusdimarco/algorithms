/**
 * A custom class to determine the greediest load of spices
 * that can be contained within a fractional knapsack of
 * varying capacities.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarcusKnapsack {
    private int capacity;
    private int value;
    private int spicesHeld;
    private HashMap<String, Integer> spiceInventory;

    public MarcusKnapsack(int capacity) {
        this.capacity = capacity;
        this.value = 0;
        this.spicesHeld = 0;
        spiceInventory = new HashMap<String, Integer>();
    }

    public void fractionalKnapsack(ArrayList<MarcusSpice> spices) {

        // Reset spice quantities available
        for (MarcusSpice spice : spices) {
            spice.resetQuantity();
        }

        // Ensure acting on spice array sorted by price
        sortSpices(spices);

        for (int i = spices.size() - 1; i >= 0; i--) {
            int counter = 0;
            while (spices.get(i).isAvailable() && this.hasRoom()) {
                spices.get(i).putInKnapsack();
                this.addValue(spices.get(i));
                this.spicesHeld++;
                counter++;
                spiceInventory.put(spices.get(i).getName(), counter);
            }
        }

        System.out.print("Knapsack of capacity " + this.capacity + " is worth " +
                            this.value + " quatloos and contains ");

        boolean hasLooped = false;

        for (Map.Entry<String, Integer> spice : spiceInventory.entrySet()) {
            if (hasLooped) {
                System.out.print(", ");
            }
            System.out.print(spice.getValue() + " scoop");
            if (spice.getValue() != 1) {
                System.out.print("s");
            }
            System.out.print(" of " + spice.getKey());
            hasLooped = true;
        }
        System.out.println(".");
}

    public void sortSpices(ArrayList<MarcusSpice> spices) {
        for (int i = 1; i < spices.size(); i++) {
            MarcusSpice keySpice = spices.get(i);
            for (int j = i - 1; j >= 0; j--) {
                // Move all items larger than key forward 1 index
                if (keySpice.getPrice() < spices.get(j).getPrice()) {
                    spices.set(j + 1, spices.get(j));
                    // If index 0 reached, assign it currentString
                    if (j == 0) {
                        spices.set(j, keySpice);
                    }
                } else {
                    // Insert key at index ahead of first smaller element
                    spices.set(j + 1, keySpice);
                    break;
                }
            }
        }
    }

    // Setter and getter for capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void addValue(MarcusSpice spice) {
        this.value += spice.getPrice();
    }

    public boolean hasRoom() {
        if (this.spicesHeld >= this.capacity) {
            return false;
        }

        return true;
    }
}
