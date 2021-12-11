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
                // Skip comment if null or if graph has been printed
                    if (graph == null || graph.hasBeenPrinted()) {
                        graphRead.nextLine();
                    } else {
                        // Run SSSP
                        graph.singleSourceShortestPath(graph.getInitialVertex());
                        graph.printSSSP(graph.getInitialVertex());
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
                        MarcusEdge edge = new MarcusEdge(first, second, edgeWeight);
                        first.addEdge(edge);
                        graph.addEdge(edge);
                    }
                }
            }
            graph.singleSourceShortestPath(graph.getInitialVertex());
            graph.printSSSP(graph.getInitialVertex());
            graphRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find graphs2.txt");
            e.printStackTrace();
        }

    }
}
