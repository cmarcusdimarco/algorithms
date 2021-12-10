/**
 * A custom implementation of graphs as an object containing
 * vertices and edges. Supports matrices, adjacency lists,
 * and linked objects, as well as both depth-first traversals
 * and breadth-first traversals.
 */
import java.util.ArrayList;

public class MarcusGraphs {
    private ArrayList<MarcusVertex> vertices;
    private MarcusVertex initialVertex;

    // Default constructor
    public MarcusGraphs() {
        this.vertices = new ArrayList<MarcusVertex>();
        this.initialVertex = null;
    }

    // Prints a matrix of all vertices, printing a 1 at the intersection
    // if there is an edge present and printing a . if not
    public void printMatrix() {
        for (int i = -1; i < vertices.size(); i++) {
            for (int j = -1; j < vertices.size(); j++) {
                if (i == -1 && j == -1) {
                    // Top left corner is blank space
                    System.out.printf("%3s", "");
                } else if (i == -1) {
                    // Top row is vertex IDs
                    System.out.printf("%3s", vertices.get(j).getId() + " ");
                } else if (j == -1) {
                    // First column is vertex IDs
                    System.out.printf("%3s", vertices.get(i).getId() + " ");
                } else if (vertices.get(i).hasNeighbor(vertices.get(j))) {
                    // If the vertices are neighbors, print weight
                    System.out.printf("%3s",
                               vertices.get(i).weightToVertex(vertices.get(j)));
                } else {
                    // If not neighbors, print .
                    System.out.printf("%3s", ". ");
                }
            }
            // New line
            System.out.print("\n\n");
        }
    }

    // Prints each vertex followed by its neighbors
    public void printAdjacencyList() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("[" + vertices.get(i).getId() + "] ");
            vertices.get(i).printNeighbors();
        }
        System.out.print("\n");
    }

    // Traverses a graph vertex-by-vertex, going as deep as possible from
    // the source before moving on to the next vertex. Prints IDs as
    // encountered.
    public void depthFirstTraversal(MarcusVertex source) {

        if (!source.getIsProcessed()) {
            System.out.print(source.getId() + " ");
            source.setIsProcessed(true);
        }
        for (MarcusEdge currentEdge : source.getEdges()) {
            if (!currentEdge.getDestination().getIsProcessed()) {
                depthFirstTraversal(currentEdge.getDestination());
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
            for (MarcusEdge each : currentVertex.getEdges()) {
                if (!each.getDestination().getIsProcessed()) {
                    queue.enqueue(each.getDestination());
                    each.getDestination().setIsProcessed(true);
                }
            }
        }

        System.out.print("\n\n");
    }

    // Reset isProcessed for each vertex in the graph
    public void resetBooleans() {
        for (MarcusVertex currentVertex : vertices) {
            currentVertex.setIsProcessed(false);
        }
    }

    // Add vertex to ArrayList and set initialVertex if needed
    public void addVertex(MarcusVertex vertex) {
        this.vertices.add(vertex);
        if (this.initialVertex == null) {
            this.initialVertex = vertex;
        }
    }

    public MarcusVertex getVertexById(int vertexId) {
        MarcusVertex returnVertex = null;

        for (MarcusVertex currentVertex : vertices) {
            if (currentVertex.getId() == vertexId) {
                returnVertex = currentVertex;
                break;
            }
        }

        return returnVertex;
    }

    public MarcusVertex getInitialVertex() {
        return initialVertex;
    }
}
