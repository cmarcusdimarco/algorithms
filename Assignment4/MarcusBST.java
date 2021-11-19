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
    }

    public MarcusBST(MarcusNode root) {
        this.root = root;
    }

    // insertNode finds the correct space in the tree for the node,
    // then sets parent/child relationships for the nodes involved
    public void insertNode(MarcusNode node) {
        MarcusNode currentNode = root;
        MarcusNode trailingNode = null;

        // Find the correct space in the tree
        while (currentNode != null) {
            trailingNode = currentNode;
            if (node.getItem().compareToIgnoreCase(currentNode.getItem()) < 0) {
                currentNode = currentNode.getLeftChild();
            } else {
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

    public String search(MarcusNode root, String target) {
        if (root == null) { 
            return "Target not found.";
        } else if (root.getItem().compareTo(target) == 0) {
            return target;
        } else {
            if (target.compareToIgnoreCase(root.getItem()) < 0) {
                System.out.print("L, ");
                return search(root.getLeftChild(), target);
            } else {
                System.out.print("R, ");
                return search(root.getRightChild(), target);
            }
        }
    }

    // Setters and getters for private fields
    public String getPath() {
        return this.path;
    }

    public void resetPath() {
        this.path = null;
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }
}
