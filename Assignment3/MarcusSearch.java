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
                return;
            }
        }

        // If not found, print message and counter
        this.printFailureMessage();
    }

    // Abstracting binarySearch() for ease-of-use and to ensure
    // proper counter functionality
    public void binarySearch(String[] array, String target) {

        // Start with counter at 0
        this.resetCounter();

        // Private binary search method
        int indexOfTarget = binarySearch(array, 0, array.length - 1, target);

        // Print message conditional on if target was found
        if (indexOfTarget == -1) {
            this.printFailureMessage();
        } else {
            this.printCompletionMessage();
        }
    }

    /// Binary search will take a midpoint of the sorted array and
    // compare the target, recursively calling binary search on the
    // half of the array that would contain the sorted target
    // until found or a base case is reached.
    private int binarySearch(String[] array, int leftIndex, int rightIndex, String target) {

        // Check for IndexOutOfBoundsException
        if (rightIndex >= 1) {
            int midpoint = (leftIndex + rightIndex) / 2;

            // If the target is at the midpoint index, return the index
            // If less than the value at midpoint, search the left half
            // If greater than the value at midpoint, search the upper half
            if (target.compareToIgnoreCase(array[midpoint]) == 0) {
                counter++;      // Increment for if
                return midpoint;
            } else if (target.compareToIgnoreCase(array[midpoint]) < 0) {
                counter += 2;   // Increment for if and else if
                return binarySearch(array, leftIndex, midpoint - 1, target);
            } else {
                counter += 2;   // Increment for if and else if
                return binarySearch(array, midpoint + 1, rightIndex, target);
            }
        } else {
            // Return -1 if value not found
            return -1;
        }
    }

    // Getter for counter
    public int getCounter() {
        return counter;
    }

    // Controlling setter functionality to only reset to 0
    public void resetCounter() {
        counter = 0;
    }

    // Message to print upon completing search which includes counter
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
