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
        MarcusStack stack = new MarcusStack();
        MarcusQueue queue = new MarcusQueue();

        try {
            File file = new File("./Assignment1/magicitems.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                MarcusNode item = new MarcusNode(read.nextLine());
                queue.enqueue(item);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find magicitems.txt");
            e.printStackTrace();
        }
    }
}