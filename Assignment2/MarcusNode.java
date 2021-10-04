/**
 * Custom Node class which will serve as the container for
 * individual characters from the strings to be tested.
 * Must point to another Node object or null.
 */
public class MarcusNode {
    private String item;
    private MarcusNode next;

    // Not having a default constructor forces String input
    public MarcusNode(String item) {
        this.item = item;
        this.next = null;
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
}