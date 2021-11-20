/**
 * Custom binary search tree class which will allow for
 * the lookup of data in log(n) time by linking up to 2
 * MarcusNodes as left/right children in a sorted order.
 */
public class MarcusBST {
    private MarcusNode root;
    private String path;
    private int counter;

    // Default constructor
    public MarcusBST() {
        this.root = null;
        this.path = "";
    }

    public MarcusBST(MarcusNode root) {
        this.root = root;
        this.path = "";
    }

    // insertNode finds the correct space in the tree for the node,
    // then sets parent/child relationships for the nodes involved
    public void insertNode(MarcusNode node) {
        MarcusNode currentNode = root;
        MarcusNode trailingNode = null;

        this.resetPath();

        // Find the correct space in the tree
        while (currentNode != null) {
            trailingNode = currentNode;
            if (!this.path.equals("")) {
                this.path += ", ";
            }
            if (node.getItem().compareToIgnoreCase(currentNode.getItem()) < 0) {
                this.path += "L";
                currentNode = currentNode.getLeftChild();
            } else {
                this.path += "R";
                currentNode = currentNode.getRightChild();
            }
        }

        // Set parent/child relationships
        if (trailingNode == null) {
            this.root = node;
        } else {
            node.setParent(trailingNode);
            if (node.getItem().compareToIgnoreCase(trailingNode.getItem()) < 0) {
                trailingNode.setLeftChild(node);
            } else {
                trailingNode.setRightChild(node);
            }
        }
    }

    // Public-facing abstraction for proper counter and path tracking
    public void search(String target) {

        // Reset counter and path
        this.resetCounter();
        this.resetPath();

        // Execute private recursive method
        search(this.getRoot(), target);
    }


    // search recursively iterates through the BST to find the target
    // in log(n) time, counting comparisons and printing the path
    private String search(MarcusNode root, String target) {

        if (root == null) { 
            return "Target not found.";
        } else if (root.getItem().compareTo(target) == 0) {
            counter++;
            return target;
        } else {
            counter++;
            if (this.path != null) {
                this.path += ", ";
            }
            if (target.compareToIgnoreCase(root.getItem()) < 0) {
                this.path += "L";
                return search(root.getLeftChild(), target);
            } else {
                this.path += "R";
                return search(root.getRightChild(), target);
            }
        }
    }

    public void inOrderTraversal(MarcusNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeftChild());
        System.out.println(node.getItem());
        inOrderTraversal(node.getRightChild());
    }

    // Setters and getters for private fields
    public String getPath() {
        return this.path;
    }

    public void resetPath() {
        this.path = "";
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public MarcusNode getRoot() {
        return this.root;
    }
}
