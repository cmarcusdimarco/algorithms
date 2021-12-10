/**
 * A custom implementation of a vertex object for
 * representing graphs as linked objects.
 */
import java.util.ArrayList;

public class MarcusVertex {
    private int id;
    private boolean isProcessed;
    private ArrayList<MarcusEdge> edges;
    private MarcusVertex next;
    private int cost;
    private MarcusVertex shortestSource;


    public MarcusVertex(int id) {
        this.id = id;
        this.isProcessed = false;
        this.edges = new ArrayList<MarcusEdge>();
        this.next = null;
        this.cost = 0;
        this.shortestSource = null;
    }

    public boolean hasNeighbor(MarcusVertex neighbor) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDestination().getId() == neighbor.getId()) {
                return true;
            }
        }

        return false;
    }

    public int weightToVertex(MarcusVertex neighbor) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDestination().getId() == neighbor.getId()) {
                return edges.get(i).getWeight();
            }
        }

        System.out.println("No matching edge found.");
        return -2112;
    }

    // Setters and getters for private fields
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public void addEdge(MarcusEdge edge) {
        if (edge.getSource().id != this.id) {
            System.out.println("This is not the edge you're looking for...");
            System.out.println("(Source of edge does not match this vertex)");
            return;
        }
        this.edges.add(edge);
    }

    public ArrayList<MarcusEdge> getEdges() {
        return this.edges;
    }

    public void printNeighbors() {
        for (MarcusEdge currentEdge : edges) {
            System.out.print(currentEdge.getDestination().getId() + " ");
        }
        System.out.print("\n");
    }

    public void setNext(MarcusVertex next) {
        this.next = next;
    }

    public MarcusVertex getNext() {
        return this.next;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setShortestSource(MarcusVertex source) {
        this.shortestSource = source;
    }

    public MarcusVertex getShortestSource() {
        return shortestSource;
    }
}
