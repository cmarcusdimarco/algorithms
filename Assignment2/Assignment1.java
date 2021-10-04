/**
 * A program which reads a String from a file and uses a Stack and Queue
 * to compare it to its reverse order. If the Stack output and Queue output
 * match, prints the String and increments a palindrome counter.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Assignment1 {
    // Method to return a String with only lowercase letters
    public static String onlyLettersToLowercase(String string) {
        String returnString = string.toLowerCase();
        returnString = returnString.replaceAll("[^a-z]", "");
        return returnString;
    }

    public static void main(String[] args) {
        MarcusStack stack = new MarcusStack();          // Stack for testing palindromes
        MarcusQueue queue = new MarcusQueue();          // Queue for testing palindromes
        MarcusQueue masterQueue = new MarcusQueue();    // For Strings from File

        // Try/catch block for file import and reading
        try {
            File file = new File("magicitems.txt");
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

        // Iterate through list
        while (!masterQueue.isEmpty()) {
            String string = masterQueue.dequeue().getItem();    // Original String
            String lowercase = onlyLettersToLowercase(string);  // Parsed
            String forwardsString = "";
            String backwardsString = "";

            // Load a stack and a queue with the lowercase parsed String by character
            for (int i = 0; i < lowercase.length(); i++) {
                MarcusNode stackNode = new MarcusNode(lowercase.substring(i, i + 1));
                MarcusNode queueNode = new MarcusNode(lowercase.substring(i, i + 1));
                stack.push(stackNode);
                queue.enqueue(queueNode);
            }

            // Create forwards String from queue and backwards String from stack
            while(!stack.isEmpty()) {
                forwardsString += queue.dequeue().getItem();
                backwardsString += stack.pop().getItem();
            }

            // Compare forwards and backwards for equality, print original if equal
            if (forwardsString.equals(backwardsString)) {
                System.out.println(string);
            }
        }
    }
}