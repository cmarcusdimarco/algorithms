/**
 * A program which reads a constant number of Strings
 * from a file, sorts it using a custom sort library,
 * then searches for a random 42 items using custom
 * linear and binary search implementations. Then,
 * hashes the Strings into a table and retrieves the
 * 42 items.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        final int NUM_OF_ITEMS = 666;                   // Length of file as constant
        final int NUM_OF_ITEMS_TO_FIND = 42;            // Number of items to find as constant
        String[] magicItems = new String[NUM_OF_ITEMS]; // Array of file strings
        MarcusSort sorter = new MarcusSort();           // Instance of MarcusSort
        MarcusSearch searcher = new MarcusSearch();     // Instance of MarcusSearch

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

        // Select 42 items at random from magicitems[] and populate a subarray
        sorter.notRosannaShuffle(magicItems);
        String[] magicItemTargets = new String[NUM_OF_ITEMS_TO_FIND];
        for (int i = 0; i < magicItemTargets.length; i++) {
            magicItemTargets[i] = magicItems[i];
        }

        // Sort magicitems[]
        sorter.quickSort(magicItems);

        // Use linear search and print comparisons
        double averageComparisons = 0;
        for (int i = 0; i < magicItemTargets.length; i++) {
            searcher.linearSearch(magicItems, magicItemTargets[i]);
            averageComparisons += searcher.getCounter();
        }
        averageComparisons /= magicItemTargets.length;
        System.out.printf("Average comparisons for linear search: %.2f", averageComparisons);
        System.out.println();

        // Use binary search and print comparisons
        averageComparisons = 0;
        for (int i = 0; i < magicItemTargets.length; i++) {
            searcher.binarySearch(magicItems, magicItemTargets[i]);
            averageComparisons += searcher.getCounter();
        }
        averageComparisons /= magicItemTargets.length;
        System.out.printf("Average comparisons for binary search: %.2f", averageComparisons);
        System.out.println();

        // Hash magicitems[]

        // Retrieve the 42 items from the hash table, printing comparisons
    }
}
