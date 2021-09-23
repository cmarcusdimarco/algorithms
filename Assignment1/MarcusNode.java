/**
 * Custom Node class which will serve as the container for individual
 * characters from the strings to be tested. Must ignore spaces and
 * capitalization, and must point to another Node object or null.
 */
public class MarcusNode {
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
}