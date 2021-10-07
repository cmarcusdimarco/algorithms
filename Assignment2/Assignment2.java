/**
 * A program which reads a constant number of Strings
 * from a file and sorts them using various methods,
 * comparing the efficiency of the sorts by
 * printing the number of comparisons for each.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        final int NUM_OF_ITEMS = 666;                   // Length of file as constant
        String[] magicItems = new String[NUM_OF_ITEMS]; // Array of file strings
        MarcusSort sorter = new MarcusSort();           // Instance of MarcusSort

        // Try/catch block for file import and reading
        try {
            File file = new File("magicitems.txt");
            Scanner read = new Scanner(file);
            for (int i = 0; i < NUM_OF_ITEMS; i++) {
                magicItems[i] = read.nextLine();
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find magicitems.txt");
            e.printStackTrace();
        }

        // Shuffle array before beginning sorts

        // Sort using selection sort, print comparisons

        // Sort using insertion sort, print comparisons

        // Sort using merge sort, print comparisons

        // Sort using quicksort, print comparisons

        sorter.selectionSort(magicItems);
        for (String each : magicItems) {
            System.out.println(each);
        }
    }
}
