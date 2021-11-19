/**
 * Custom Node class which will serve as the container for
 * individual characters from the strings to be tested.
 * Must point to another Node object or null.
 * 
 * Update, Assignment4: Instead of @next, points to up to
 * two children and up to one parent.
 */
public class MarcusNode {
    private String item;
    private MarcusNode leftChild;
    private MarcusNode rightChild;
    private MarcusNode parent;

    // Not having a default constructor forces String input
    public MarcusNode(String item) {
        this.item = item;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public MarcusNode(String item, MarcusNode parent) {
        this.item = item;
        this.parent = parent;
    }

    // Setters and getters for private fields
    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setLeftChild(MarcusNode leftChild) {
        this.leftChild = leftChild;
    }

    public MarcusNode getLeftChild() {
        return this.leftChild;
    }

    public void setRightChild(MarcusNode rightChild) {
        this.rightChild = rightChild;
    }

    public MarcusNode getRightChild() {
        return this.rightChild;
    }

    public void setParent(MarcusNode parent) {
        this.parent = parent;
    }

    public MarcusNode getParent() {
        return this.parent;
    }
}