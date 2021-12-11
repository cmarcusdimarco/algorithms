/**
 * A class to withhold counters of case instances and tests used,
 * as well as methods to test an array of ints for positive cases.
 */

public class MarcusTest {
    private int cases;
    private int tests;
    
    public MarcusTest() {
        this.cases = 0;
        this.tests = 0;
    }

    // test() returns 0 if a negative result is detected and 
    // 1 if a positive result is detected
    public int test(int individual) {
        tests++;
        return individual;
    }

    // test() returns 1 if a positive is detected and 0
    // if not
    public int test(int[] group) {
        for (int each : group) {
            if (each != 0) {
                tests++;
                return 1;
            }
        }
        tests++;
        return 0;
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
