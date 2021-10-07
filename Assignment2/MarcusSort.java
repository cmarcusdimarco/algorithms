/**
 * Custom Sort library including selection sort, insertion sort,
 * merge sort and quick sort.
 */

public class MarcusSort {
    
    // Selection sort will search for minimum unsorted value and
    // place it at first unsorted index.
    public String[] selectionSort(String[] strings) {
        
        // First unsorted index through each pass is i
        for (int i = 0; i < strings.length; i++) {
            int minIndex = i;
            // Find index of smallest value in remainder of array
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[minIndex].compareToIgnoreCase(strings[j]) > 0) {
                    minIndex = j;
                }
            }
            // Swap indices minIndex and i
            String temp = strings[i];
            strings[i] = strings[minIndex];
            strings[minIndex] = temp;
        }
        return strings;
    }

    public void insertionSort() {

    }

    public void mergeSort() {

    }

    public void quickSort() {

    }
}
