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
        return strings;
    }

    // Insertion sort will sort the array from index 0 through i,
    // 'inserting' each value into its correct position.
    public String[] insertionSort(String[] strings) {

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
        return strings;
    }

    /**
     * mergeSort() is an abstraction for cleaner user interaction. It will reset
     * the counter, call the recursive merge function, and then print the completion
     * message with the number of comparisons.
     * @param strings
     * @return String[]
     */
    public String[] mergeSort(String[] strings) {

        // Start with counter at 0
        this.resetCounter();

        // Nest recursive function inside for readability and proper
        // counter/print calls
        String[] returnStrings = this.merge(strings);

        // Print completion message with number of comparisons
        this.printCompletionMessage();
        return returnStrings;
    }

    // Merge sort will divide the array recursively until subarrays are
    // of size 1, then merge the subarrays together in sorted order

    private String[] merge(String[] strings) {
        
        // Base case
        counter++;
        if (strings.length == 1) {
            return strings;
        } else {
            int midpoint = strings.length / 2;
            String[] stringsL = new String[midpoint];
            String[] stringsR = new String[strings.length - midpoint];
            String[] returnStrings = new String[strings.length];
            
            for (int i = 0; i < stringsL.length; i++) {
                counter++;
                stringsL[i] = strings[i];
            }
            counter++;

            for (int j = 0; j < stringsR.length; j++) {
                counter++;
                stringsR[j] = strings[midpoint + j];
            }
            counter++;
            
            merge(stringsL);
            merge(stringsR);

            int i = 0;
            int j = 0;
            int k = 0;
            while (i < stringsL.length && j < stringsR.length) {
                if (stringsL[i].compareToIgnoreCase(stringsR[j]) < 0) {
                    returnStrings[k++] = stringsL[i++];
                } else {
                    returnStrings[k++] = stringsR[j++];
                }
            }
            if (i == stringsL.length) {
                for ( ; k < returnStrings.length; k++) {
                    returnStrings[k] = stringsR[j++];
                }
            } else {
                for ( ; k < returnStrings.length; k++) {
                    returnStrings[k] = stringsL[i++];
                }
            }
            return returnStrings;
        }
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
        System.out.println("Sort complete! Number of comparisons: "
                           + counter);
    }
}
