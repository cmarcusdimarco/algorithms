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
    public void selectionSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // First unsorted index through each pass is i
        for (int i = 0; i < strings.length; i++) {
            counter++;          // Comparison in for loop
            int minIndex = i;
            // Find index of smallest value in remainder of array
            for (int j = i + 1; j < strings.length; j++) {
                counter += 2;   // Comparisons in for loop and if statement
                if (strings[minIndex].compareToIgnoreCase(strings[j]) > 0) {
                    minIndex = j;
                }
            }
            counter++;          // Comparison for inner loop termination

            // Swap indices minIndex and i
            String temp = strings[i];
            strings[i] = strings[minIndex];
            strings[minIndex] = temp;
        }
        counter++;              // Comparison for outer loop termination

        // Print completion message with number of comparisons
        this.printCompletionMessage();
    }

    // Insertion sort will sort the array from index 0 through i,
    // 'inserting' each value into its correct position.
    public void insertionSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // Start comparisons at index 1
        for (int i = 1; i < strings.length; i++) {
            counter++;      // Comparison in outer loop
            String keyString = strings[i];
            for (int j = i - 1; j >= 0; j--) {
                counter += 2;   // Inner loop and if statement
                // Move all items larger than key forward 1 index
                if (keyString.compareToIgnoreCase(strings[j]) < 0) {
                    strings[j + 1] = strings[j];
                    counter++;  // Second comparison in if statement
                    // If index 0 reached, assign it currentString
                    if (j == 0) {
                        strings[j] = keyString;
                    }
                } else {
                    // Insert key at index ahead of first smaller element
                    strings[j + 1] = keyString;
                    break;
                }
            }
            counter++;      // Comparison for inner loop termination
        }
        counter++;          // Comparison for outer loop termination

        // Print completion message with number of comparisons
        this.printCompletionMessage();
    }

    /**
     * mergeSort() is an abstraction for cleaner user interaction. It will reset
     * the counter, call the recursive merge function, and then print the completion
     * message with the number of comparisons.
     * @param strings
     */
    public void mergeSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // Nest recursive function inside for readability and proper
        // counter/print calls
        this.sortThenMerge(strings, 0, strings.length - 1);

        // Print completion message with number of comparisons
        this.printCompletionMessage();
    }

    // Merge sort will divide the array recursively until subarrays are
    // of size 1, then merge the subarrays together in sorted order.
    private void sortThenMerge(String[] strings, int leftIndex, int rightIndex) {
        
        counter++;      // Increment the if comparison
        if (leftIndex < rightIndex) {
            int midpoint = (leftIndex + rightIndex) / 2;
            sortThenMerge(strings, leftIndex, midpoint);
            sortThenMerge(strings, midpoint + 1, rightIndex);
            merge(strings, leftIndex, midpoint, rightIndex);
        }
    }

    // Merge will take an array, create two sorted subarrays, and
    // sort the elements in place.
    private void merge(String[] strings, int leftIndex, int midpoint,
                       int rightIndex) {

        // Create two (sorted, due to recursion) subarrays
        String[] stringsL = new String[midpoint - leftIndex + 1];
        String[] stringsR = new String[rightIndex - midpoint];
        
        // Populate the subarrays, incrementing for each comparison
        for (int i = 0; i < stringsL.length; i++) {
            counter++;
            stringsL[i] = strings[leftIndex + i];
        }
        counter++;      // Increment the loop exit comparison

        for (int j = 0; j < stringsR.length; j++) {
            counter++;
            stringsR[j] = strings[midpoint + j + 1];
        }
        counter++;      // Increment the loop exit comparison

        int i = 0;
        int j = 0;
        int k = leftIndex;
        while (i < stringsL.length && j < stringsR.length) {
            counter += 2;   // Increment for loop and if statements
            if (stringsL[i].compareToIgnoreCase(stringsR[j]) < 0) {
                strings[k++] = stringsL[i++];
            } else {
                strings[k++] = stringsR[j++];
            }
        }
        if (i == stringsL.length) {
            for ( ; k <= rightIndex; k++) {
                counter++;
                strings[k] = stringsR[j++];
            }
            counter += 2;   // Increment for loop exit and if
        } else {
            for ( ; k <= rightIndex; k++) {
                counter++;
                strings[k] = stringsL[i++];
            }
            counter += 2;   // Increment for loop exit and if
        }
    }

    /**
     * quickSort() is an abstraction for cleaner user interaction. It will reset
     * the counter, call the recursive quicksort function, and print the
     * completion message with the number of comparisons.
     * @param strings
     */
    public void quickSort(String[] strings) {

        // Set counter to 0
        this.resetCounter();

        // Nest recursive function inside for readability and proper
        // counter/print calls
        this.quickSort(strings, 0, strings.length - 1);

        // Print completion message with number of comparisons
        this.printCompletionMessage();
    }

    // Quicksort will take an array and recursively divide it around
    // a pivot value, sorting the elements around the pivots
    private void quickSort(String[] strings, int leftIndex, int rightIndex) {

        counter++;      // Increment for if comparison
        if (leftIndex < rightIndex) {
            // Quicksort the elements to either side of the partition
            int partition = partition(strings, leftIndex, rightIndex);
            quickSort(strings, leftIndex, partition - 1);
            quickSort(strings, partition + 1, rightIndex);
        }
    }

    // Partitions an array around a pivot value and places all values
    // smaller than the pivot to its left, then places pivot at its sorted index
    private int partition(String[] strings, int leftIndex, int rightIndex) {

        String pivotString = strings[rightIndex];

        int sortedIndex = leftIndex;

        for (int i = leftIndex; i <= rightIndex; i++) {
            counter += 2;       // Increment for loop and if statement
            if (strings[i].compareToIgnoreCase(pivotString) < 0) {
                // If element at i is smaller than pivot, place in the
                // left half of the array
                String tempString = strings[sortedIndex];
                strings[sortedIndex++] = strings[i];
                strings[i] = tempString;
            }
        }
        counter++;      // Increment for loop exit comparison

        // Swap pivot string and value at the pivot's sorted index
        strings[rightIndex] = strings[sortedIndex];
        strings[sortedIndex] = pivotString;
        return sortedIndex;
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
        System.out.println("Sort complete! Number of comparisons: "
                           + counter);
    }
}
