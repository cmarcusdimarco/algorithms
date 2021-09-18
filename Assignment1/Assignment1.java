/**
 * Custom Node class which will serve as the container for individual
 * characters from the strings to be tested. Must ignore spaces and
 * capitalization, and must point to another Node object or null.
 */
class MarcusNode {
    private String item;
    private MarcusNode next;

    // Not having a default constructor forces String input
    public MarcusNode(String item) {
        this.item = item;
        this.next = null;
        // Idea: control input with a method which combines toLowercase and replaceAll for readability
        // Second idea: don't do that - preserve original input and format output based on requirements
    }

    public MarcusNode(String item, MarcusNode next) {
        this.item = item;
        this.next = next;
    }

    // Setters and getters for private fields
    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setNext(MarcusNode next) {
        this.next = next;
    }

    public MarcusNode getNext() {
        return this.next;
    }

/**
 * Custom Stack class which will take Nodes as input and will output
 * those Nodes in reverse order.
 */
class MarcusStack {
    private MarcusNode head;

    // Default constructor
    public MarcusStack() {
        this.head = null;
    }

    // Setters and getters for private field head
    public void setHead(MarcusNode head) {
        this.head = head;
    }

    public MarcusNode getHead() {
        return this.head;
    }
    
    // Pushes a node on top of the stack
    public void push(MarcusNode node) {
        node.setNext(this.head);        // Will set null if stack is empty
        this.head = node;
    }

    // Pops a node off the top of the stack
    public MarcusNode pop() {
        private MarcusNode returnNode = this.head;
        if (this.isEmpty()) {           // Checks if stack is empty before accessing head.next
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

/**
 * Custom Queue class which will take Nodes as input and will output
 * those Nodes in same order.
 */
class MarcusQueue {
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
        if (this.isEmpty) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    // Dequeues a node from the front of the queue
    public MarcusNode dequeue() {
        private MarcusNode returnNode = this.head;
        if (this.isEmpty) {             // First call to isEmpty checks for stack underflow
            return returnNode;
        } else {
            this.head = returnNode.next();
            if (this.isEmpty) {         // Second call to isEmpty checks if tail needs to be assigned null
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

/**
 * A program which reads a String from a file and uses a Stack and Queue
 * to compare it to its reverse order. If the Stack output and Queue output
 * match, prints the String and increments a palindrome counter.
 */
class Assignment1 {
    public static void main(String[] args) {
    // Needs Scanner, source file, array of String objects
    }
}