/**
 * Custom Queue class which will take Nodes as input and will output
 * those Nodes in same order.
 */
public class MarcusQueue {
    private MarcusNode head;
    private MarcusNode tail;

    // Default constructor
    public MarcusQueue() {
        this.head = null;
        this.tail = null;
    }

    // Setters and getters for private fields
    public void setHead(MarcusNode head) {
        this.head = head;
    }

    public MarcusNode getHead() {
        return this.head;
    }

    public void setTail(MarcusNode tail) {
        this.tail = tail;
    }

    public MarcusNode getTail() {
        return this.tail;
    }

    // Enqueues an item to the end of the queue
    public void enqueue(MarcusNode node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    // Dequeues a node from the front of the queue
    public MarcusNode dequeue() {
        MarcusNode returnNode = this.head;
        if (this.isEmpty()) {       // Checks for stack underflow
            return returnNode;
        } else {
            this.head = returnNode.getNext();
            if (this.isEmpty()) {   // Checks if tail needs to be assigned null
                this.tail = null;
            }
            return returnNode;
        }
    }

    // Returns true if queue is empty
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
}
