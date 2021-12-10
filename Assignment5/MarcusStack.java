/**
 * Custom Stack class which will take Nodes as input and will output
 * those Nodes in reverse order.
 */
public class MarcusStack {
    private MarcusVertex head;

    // Default constructor
    public MarcusStack() {
        this.head = null;
    }

    // Setters and getters for private field head
    public void setHead(MarcusVertex head) {
        this.head = head;
    }

    public MarcusVertex getHead() {
        return this.head;
    }
    
    // Pushes a node on top of the stack
    public void push(MarcusVertex node) {
        node.setNext(this.head);    // Will set null if stack is empty
        this.head = node;
    }

    // Pops a node off the top of the stack
    public MarcusVertex pop() {
        MarcusVertex returnNode = this.head;
        if (this.isEmpty()) {       // Catch stack underflow
            return returnNode;
        } else {
            this.head = head.getNext();
            return returnNode;
        }
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
}
