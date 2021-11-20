/**
 * A custom implementation of graphs as an object containing
 * vertices and edges. Supports matrices, adjacency lists,
 * and linked objects, as well as both depth-first traversals
 * and breadth-first traversals.
 */
import java.util.ArrayList;

public class MarcusGraphs {
    private ArrayList<MarcusVertex> vertices;

    // Default constructor
    public MarcusGraphs() {
        this.vertices = new ArrayList<MarcusVertex>();
    }

    // Prints a matrix of all vertices, printing a 1 at the intersection
    // if there is an edge present and printing a . if not
    public void printMatrix() {
        for (int i = -1; i < vertices.size(); i++) {
            for (int j = -1; j < vertices.size(); j++) {
                if (i == -1 && j == -1) {
                    // Top left corner is blank space
                    System.out.print("  ");
                } else if (i == -1) {
                    // Top row is vertex IDs
                    System.out.print(vertices.get(j).getId() + " ");
                } else if (j == -1) {
                    // First column is vertex IDs
                    System.out.print(vertices.get(i).getId() + " ");
                } else if (vertices.get(i).hasNeighbor(vertices.get(j))) {
                    // If the vertices are neighbords, print 1
                    System.out.print("1 ");
                } else {
                    // If not neighbors, print .
                    System.out.print(". ");
                }
            }
            // New line
            System.out.print("\n");
        }
    }

    // Prints each vertex followed by its neighbors
    public void printAdjacencyList() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("[" + vertices.get(i) + "] ");
            vertices.get(i).printNeighbors();
        }
    }

    // Traverses a graph vertex-by-vertex, going as deep as possible from
    // the source before moving on to the next vertex. Prints IDs as
    // encountered.
    public void depthFirstTraversal(MarcusVertex source) {

        if (!source.getIsProcessed()) {
            System.out.print(source.getId() + " ");
            source.setIsProcessed(true);
        }
        for (MarcusVertex currentVertex : source.getNeighbors()) {
            if (!currentVertex.getIsProcessed()) {
                depthFirstTraversal(currentVertex);
            }
        }
    }

    // Traverses a graph using a queue. Prints IDs as dequeued.
    public void breadthFirstTraversal(MarcusVertex source) {
        MarcusVertex currentVertex;

        // Reset booleans from depth-first traversal
        this.resetBooleans();

        // Enqueue when encountered
        MarcusQueue queue = new MarcusQueue();
        queue.enqueue(source);
        source.setIsProcessed(true);
        while (!queue.isEmpty()) {
            currentVertex = queue.dequeue();
            System.out.print(currentVertex.getId() + " ");
            for (MarcusVertex each : currentVertex.getNeighbors()) {
                if (!each.getIsProcessed()) {
                    queue.enqueue(each);
                    each.setIsProcessed(true);
                }
            }
        }
    }

    // Reset isProcessed for each vertex in the graph
    public void resetBooleans() {
        for (MarcusVertex currentVertex : vertices) {
            currentVertex.setIsProcessed(false);
        }
    }

    public void addVertex (MarcusVertex vertex) {
        this.vertices.add(vertex);
    }
}
