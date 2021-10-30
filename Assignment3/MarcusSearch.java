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
    
    // Linear search will search the entire array in order,
    // halting once the target has been found
    public void linearSearch(String[] array, String target) {

        // Start with counter at 0
        this.resetCounter();

        // Search the array in indexed order for the target
        for (int i = 0; i < array.length; i++) {
            counter++;
            // If found, print completion message and break
            if (array[i].compareToIgnoreCase(target) == 0) {
                this.printCompletionMessage();
                break;
            }
        }

        // If not found, print message and counter
        this.printFailureMessage();
    }

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

    // Message to print if search completed without finding target
    public void printFailureMessage() {
        System.out.println("Search complete - target not found." +
                           "\nNumber of comparisons: " + counter);
    }
}
