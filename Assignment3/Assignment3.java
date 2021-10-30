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

        // Select 42 items at random from magicitems[]

        // Use linear search and print comparisons

        // Use binary search and print comparisons

        // Hash magicitems[]

        // Retrieve the 42 items from the hash table, printing comparisons
    }
}
