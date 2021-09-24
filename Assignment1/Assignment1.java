/**
 * A program which reads a String from a file and uses a Stack and Queue
 * to compare it to its reverse order. If the Stack output and Queue output
 * match, prints the String and increments a palindrome counter.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Assignment1 {
    public static void main(String[] args) {
        MarcusStack stack = new MarcusStack();          // Stack for testing Strings for palindromes
        MarcusQueue queue = new MarcusQueue();          // Queue for testing Strings for palindromes
        MarcusQueue masterQueue = new MarcusQueue();    // Queue to contain all Strings from File

        // Try/catch block for file import and reading
        try {
            File file = new File("./Assignment1/magicitems.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                MarcusNode item = new MarcusNode(read.nextLine());
                masterQueue.enqueue(item);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find magicitems.txt");
            e.printStackTrace();
        }

        // For each item in masterQueue, force lowercase and remove extra characters
        while (!masterQueue.isEmpty()) {
            // Thinking about changing the Marcus classes to support Strings as well as Nodes
            String string = masterQueue.dequeue().getItem();
        }
    }
}