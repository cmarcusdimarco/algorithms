/**
 * Custom Sort library including selection sort, insertion sort,
 * merge sort and quick sort.
 */

public class MarcusSort {
    
    private int counter;    // Count number of comparisons

    public MarcusSort() {   // Default constructor
        counter = 0;
    }

    // Selection sort will search for minimum unsorted value and
    // place it at first unsorted index.
    public String[] selectionSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // First unsorted index through each pass is i
        for (int i = 0; i < strings.length; i++) {
            int minIndex = i;
            // Find index of smallest value in remainder of array
            for (int j = i + 1; j < strings.length; j++) {
                counter++;  // Increment for each comparison
                if (strings[minIndex].compareToIgnoreCase(strings[j]) > 0) {
                    minIndex = j;
                }
            }
            // Swap indices minIndex and i
            String temp = strings[i];
            strings[i] = strings[minIndex];
            strings[minIndex] = temp;
        }
        // Print completion message with number of comparisons
        this.printCompletionMessage();
        return strings;
    }

    // Insertion sort will sort the array from index 0 through i,
    // 'inserting' each value into its correct position.
    public String[] insertionSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // Start comparisons at index 1
        for (int i = 1; i < strings.length; i++) {
            
        }
        return strings;
    }

    public void mergeSort() {

    }

    public void quickSort() {

    }

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
        System.out.println("Sort complete! Number of comparisons: " + counter);
    }
}
