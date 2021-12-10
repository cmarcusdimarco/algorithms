/**
 * A program designed to implement the Bellman-Ford dynamic
 * programming algorithm for Single Source Shortest Path
 * on directed graphs and to implement a greedy solution to
 * fractional knapsack.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        // Read graphs2.txt and create matrix, adjacency list, and linked objects
        try {
            File graphs = new File("Assignment5/graphs2.txt");
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
                        // Run SSSP
                        System.out.println("Matrix:");
                        graph.printMatrix();
                        System.out.println("Adjacency list:");
                        graph.printAdjacencyList();
                        System.out.println("Depth-first traversal:");
                        graph.depthFirstTraversal(graph.getInitialVertex());
                        System.out.print("\n\n");
                        System.out.println("Breadth-first traversal:");
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
                        int edgeWeight = graphRead.nextInt();
                        MarcusVertex first = graph.getVertexById(a);
                        MarcusVertex second = graph.getVertexById(b);
                        first.addEdge(new MarcusEdge(first, second, edgeWeight));
                        
                    }
                }
            }
            System.out.println("Matrix:");
            graph.printMatrix();
            System.out.println("Adjacency list:");
            graph.printAdjacencyList();
            System.out.println("Depth-first traversal:");
            graph.depthFirstTraversal(graph.getInitialVertex());
            System.out.print("\n\n");
            System.out.println("Breadth-first traversal:");
            graph.breadthFirstTraversal(graph.getInitialVertex());
            graphRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find graphs1.txt");
            e.printStackTrace();
        }

    }
}
