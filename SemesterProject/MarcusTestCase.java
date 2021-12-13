/**
 * A class to withhold counters of case instances and tests used,
 * as well as methods to test an array of ints for positive cases.
 */

public class MarcusTestCase {
    private int cases;
    private int tests;
    
    public MarcusTestCase() {
        this.cases = 0;
        this.tests = 0;
    }

    public void addCase() {
        this.cases++;
    }

    public void addTests(int quantity) {
        this.tests += quantity;
    }

    // Setters and getters for private fields

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getCases() {
        return cases;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getTests() {
        return tests;
    }
}
