/**
 * A custom implementation of a hash table with chaining. Uses a hash function
 * provided at https://www.labouseur.com/courses/algorithms/Hashing.java.html
 */

public class MarcusHash {
    
    private int counter;    // Count number of comparisons

    public MarcusHash() {   // Default constructor
        counter = 0;
    }

    // Hash function
    public int makeHashCode(String string, int hashTableSize) {
        string = string.toUpperCase();
        int length = string.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling
        // their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = string.charAt(i);
            int thisValue = (int) thisLetter;
            letterTotal += thisValue;

            // Test: prints the char and the hash.
            /*
            System.out.print(" [");
            System.out.print(thisLetter);
            System.out.print(thisValue);
            System.out.print("] ");
            // */
        }

        // Scale letterTotal to fit in hashTableSize
        int hashCode = (letterTotal * 1) % hashTableSize;

        return hashCode;
    }

    // Add MarcusNode to table
    public void loadToTable(MarcusNode[] hashTable, MarcusNode node, int hashCode) {
        // Try/catch block to ensure param @hashCode will fit into param @hashTable
        try {
            if (hashTable[hashCode] == null) {
                hashTable[hashCode] = node;
            } else {
                chainToTable(hashTable[hashCode], node);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Whoops! You're passing a hash value greater than the " +
                               "size of the hash table.");
            e.printStackTrace();
        }
    }

    // Recursive chain function for hash table - only for use by loadToTable()
    private void chainToTable(MarcusNode nodeInTable, MarcusNode nodeToChain) {
        if (nodeInTable.getNext() == null) {
            nodeInTable.setNext(nodeToChain);
            return;
        } else {
            chainToTable(nodeInTable.getNext(), nodeToChain);
        }
    }

    // Retrieve value from hashTable, if exists
    public void retrieve(MarcusNode[] hashTable, String target) {
        int hashCode = makeHashCode(target, hashTable.length);
        MarcusNode currentNode = hashTable[hashCode];

        // Reset counter
        this.resetCounter();

        while (currentNode != null) {
            counter++;
            if (target.compareTo(currentNode.getItem()) == 0) {
                this.printCompletionMessage();
                return;
            } else {
                currentNode = currentNode.getNext();
            }
        }

        // If not found, print failure message
        this.printFailureMessage();
    }

    // Getter for counter
    public int getCounter() {
        return counter;
    }

    // Controlling setter functionality to only reset to 0
    public void resetCounter() {
        counter = 0;
    }

    // Message to print upon completing retrieval which includes counter
    public void printCompletionMessage() {
        System.out.println("Retrieval complete! Number of comparisons: "
                           + counter);
    }

    // Message to print if search completed without finding target
    public void printFailureMessage() {
        System.out.println("Retrieval unsuccessful - target not found." +
                           "\nNumber of comparisons: " + counter);
    }
}
