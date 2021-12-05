/**
 * A custom implementation of a vertex object for
 * representing graphs as linked objects.
 */
import java.util.ArrayList;

public class MarcusVertex {
    private int id;
    private boolean isProcessed;
    private ArrayList<MarcusVertex> neighbors;
    private MarcusVertex next;
    private int weight;

    public MarcusVertex(int id) {
        this.id = id;
        this.isProcessed = false;
        this.neighbors = new ArrayList<MarcusVertex>();
        this.next = null;
        this.weight = 0;
    }

    public boolean hasNeighbor(MarcusVertex neighbor) {
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).getId() == neighbor.getId()) {
                return true;
            }
        }

        return false;
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

    public void addNeighbor(MarcusVertex neighbor) {
        this.neighbors.add(neighbor);
    }

    public ArrayList<MarcusVertex> getNeighbors() {
        return this.neighbors;
    }

    public void printNeighbors() {
        for (MarcusVertex currentVertex : neighbors) {
            System.out.print(currentVertex.getId() + " ");
        }
        System.out.print("\n");
    }

    public void setNext(MarcusVertex next) {
        this.next = next;
    }

    public MarcusVertex getNext() {
        return this.next;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}
