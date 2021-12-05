/**
 * Custom Queue class which will take Nodes as input and will output
 * those Nodes in same order.
 * 
 * Update, Assignment 4: Converted to use MarcusVertex
 */
public class MarcusQueue {
    private MarcusVertex head;
    private MarcusVertex tail;

    // Default constructor
    public MarcusQueue() {
        this.head = null;
        this.tail = null;
    }

    // Setters and getters for private fields
    public void setHead(MarcusVertex head) {
        this.head = head;
    }

    public MarcusVertex getHead() {
        return this.head;
    }

    public void setTail(MarcusVertex tail) {
        this.tail = tail;
    }

    public MarcusVertex getTail() {
        return this.tail;
    }

    // Enqueues an item to the end of the queue
    public void enqueue(MarcusVertex node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    // Dequeues a node from the front of the queue
    public MarcusVertex dequeue() {
        MarcusVertex returnNode = this.head;
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
