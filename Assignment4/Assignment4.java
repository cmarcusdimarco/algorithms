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

public class Assignment4 {
    public static void main(String[] args) {
        final int NUM_OF_ITEMS = 666;                   // Length of file as constant
        final int NUM_OF_ITEMS_TO_FIND = 42;            // Number of items to find
        final int HASH_TABLE_SIZE = 250;                // Size of hash table
        String[] magicItems = new String[NUM_OF_ITEMS]; // Array of file strings
        MarcusSort sorter = new MarcusSort();           // Instance of MarcusSort
        MarcusSearch searcher = new MarcusSearch();     // Instance of MarcusSearch
        MarcusHash hasher = new MarcusHash();           // Instance of MarcusHash

        // Read graphs1.txt and create matrix, adjacency list, and linked objects

        // Print matrix and adjacency lists

        // Perform depth-first traversals, printing vertex IDs as encountered

        // Perform breadth-first traversals, printing IDs as encountered

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

        // Populate BST with magicItems, printing the path from the root

        // Print the entire BST with an in-order traversal

        // Read magicitems-find-in-bst.txt and lookup in BST, printing path
    }
}
