/**
 * A custom representation of edges between vertices to allow for
 * the adding of weights to a directed graph.
 */

public class MarcusEdge {
    private MarcusVertex sourceVertex;
    private MarcusVertex destinationVertex;
    private int weight;

    // Default constructor only allows for assignment of weighted edges
    public MarcusEdge(MarcusVertex source, MarcusVertex destination, int weight) {
        this.sourceVertex = source;
        this.destinationVertex = destination;
        this.weight = weight;
    }

    // Setters and getters for private fields
    public void setSource(MarcusVertex source) {
        this.sourceVertex = source;
    }

    public MarcusVertex getSource() {
        return this.sourceVertex;
    }

    public void setDestination(MarcusVertex destination) {
        this.destinationVertex = destination;
    }

    public MarcusVertex getDestination() {
        return this.destinationVertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}
