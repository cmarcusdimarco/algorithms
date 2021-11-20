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
        String[] magicItems = new String[NUM_OF_ITEMS]; // Array of file strings

        // Read graphs1.txt and create matrix, adjacency list, and linked objects
        try {
            File graphs = new File("Assignment4/graphs1.txt");
            Scanner graphRead = new Scanner(graphs);
            MarcusGraphs graph = null;
            String command = null;
            String item = null;
            while (graphRead.hasNextLine()) {
                command = graphRead.next();
                if (command.equals("--")) {
                // Skip comment if null, print and execute methods if exists
                    if (graph == null) {
                        graphRead.nextLine();
                    } else {
                        graph.printMatrix();
                        graph.printAdjacencyList();
                        graph.depthFirstTraversal(graph.getInitialVertex());
                        System.out.print("\n\n");
                        graph.breadthFirstTraversal(graph.getInitialVertex());
                    }
                } else if (command.equals("new")) {
                // Create new graph
                    graph = new MarcusGraphs();
                    graphRead.nextLine();
                } else if (command.equals("add")) {
                    item = graphRead.next();
                    if (item.equals("vertex")) {
                    // Add new vertex to graph
                        MarcusVertex vertex = new MarcusVertex(graphRead.nextInt());
                        graph.addVertex(vertex);
                    } else if (item.equals("edge")) {
                    // Add new edge to graph
                        int a = graphRead.nextInt();
                        graphRead.next();
                        int b = graphRead.nextInt();
                        MarcusVertex first = graph.getVertexById(a);
                        MarcusVertex second = graph.getVertexById(b);
                        first.addNeighbor(second);
                        second.addNeighbor(first);
                    }
                }
            }
            graph.printMatrix();
            graph.printAdjacencyList();
            graph.depthFirstTraversal(graph.getInitialVertex());
            System.out.print("\n\n");
            graph.breadthFirstTraversal(graph.getInitialVertex());
            graphRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find graphs1.txt");
            e.printStackTrace();
        }

        // Try/catch block for file import and reading
        try {
            File file = new File("Assignment4/magicitems.txt");
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
