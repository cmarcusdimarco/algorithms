/**
 * A custom search library containing implementations
 * of linear and binary search, equipped with a counter
 * for tracking comparisons.
 */

public class MarcusSearch {

    private int counter;    // Count number of comparisons

    public MarcusSearch() { // Default constructor
        counter = 0;
    }
    
    // Linear search

    // Binary search

    // Getter for counter
    public int getCounter() {
        return counter;
    }

    // Controlling setter functionality to only reset to 0
    public void resetCounter() {
        counter = 0;
    }

    // Message to print upon completing sort which includes counter
    public void printCompletionMessage() {
        System.out.println("Search complete! Number of comparisons: "
                           + counter);
    }
}
