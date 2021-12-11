/**
 * A program designed to implement the Bellman-Ford dynamic
 * programming algorithm for Single Source Shortest Path
 * on directed graphs and to implement a greedy solution to
 * fractional knapsack.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Assignment5 {
    public static void main(String[] args) {
        // Read graphs2.txt and create matrix, adjacency list, and linked objects
        try {
            File graphs = new File("graphs2.txt");
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

        try {
            File spices = new File("spice.txt");
            Scanner spiceRead = new Scanner(spices);
            String spiceCommand = null;
            String spiceItem = null;
            ArrayList<MarcusSpice> spiceArray = new ArrayList<MarcusSpice>();
            while (spiceRead.hasNextLine()) {
                spiceCommand = spiceRead.next();
                if (spiceCommand.equals("--")) {
                // Skip comment if null
                    spiceRead.nextLine();
                } else if (spiceCommand.equals("spice")) {
                // Create new spice
                    MarcusSpice spice = new MarcusSpice();
                    spiceItem = spiceRead.next();
                    if (spiceItem.equals("name")) {
                        // Add name to spice
                        spiceRead.next();
                        String name = spiceRead.next();
                        spice.setName(name.substring(0, name.length() - 1));
                        spiceItem = spiceRead.next();
                    }
                    if (spiceItem.equals("total_price")) {
                        // Add price and quantity to spice
                        spiceRead.next();
                        String price = spiceRead.next();
                        double totalPrice = Double.parseDouble(price.substring(0,
                                                            price.length() - 1));
                        spiceRead.next();
                        spiceRead.next();
                        String quantity = spiceRead.next();
                        spice.setQuantity(Integer.parseInt(quantity.substring(0,
                                                           quantity.length() - 1)));
                        spice.setPrice(totalPrice / spice.getQuantity());
                        spiceArray.add(spice);
                    }
                } else if (spiceCommand.equals("knapsack")) {
                    spiceRead.next();
                    spiceRead.next();
                    String capacityString = spiceRead.next();
                    int capacity = Integer.parseInt(capacityString.substring(0, 
                                                    capacityString.length() - 1));
                    MarcusKnapsack bag = new MarcusKnapsack(capacity);
                    bag.fractionalKnapsack(spiceArray);
                }
            }
            spiceRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("Whoops! Couldn't find spice.txt");
            e.printStackTrace();
        }
    }
}
