/**
 * An object designed to simulate pooled testing on a group.
 * Conducts tests in the way we would have to in a real world scenario -
 * abstracting the individual results and only returning the result of
 * the pool until deeper testing is conducted.
 */

public class MarcusTester {   

    // Abstraction for user - test() takes the array of cases and sample of
    // population, tests on group of size 8. If negative, case1 is
    // incremented and test1 is incremented. If positive, tests on L/R
    // subarrays. If one of these tests comes back as negative, increment
    // case 2 and conduct tests on the positive subarray.
    public void test(MarcusTestCase[] cases, int[] group, int leftIndex,
                     int rightIndex) {
        int tests = 1;
        int caseNumber = 0;

        // Using boolean to represent pooled test, since we will never
        // be able to determine individual positivity until conducting
        // individual tests in real world scenario
        if (poolIsPositive(group, leftIndex, rightIndex)) {
            int midpoint = (leftIndex + rightIndex) / 2;
            boolean leftIsPositive = poolIsPositive(group, leftIndex, midpoint);
            boolean rightIsPositive = poolIsPositive(group, midpoint + 1, rightIndex);
            tests += 2;

            if (leftIsPositive ^ rightIsPositive) {
                caseNumber = 1;
            } else {
                caseNumber = 2;
            }

            if (leftIsPositive) {
                testIndividuals(group, leftIndex, midpoint, cases[caseNumber]);
            }
            
            if (rightIsPositive) {
                testIndividuals(group, midpoint + 1, rightIndex, cases[caseNumber]);
            }

            cases[caseNumber].addCase();
            cases[caseNumber].addTests(tests);
        } else {
            cases[caseNumber].addCase();
            cases[caseNumber].addTests(tests);
        }
    }

    // Returns the result of the pooled test as a boolean without shortcircuiting
    // in order to represent real world conditions
    private boolean poolIsPositive(int[] group, int leftIndex, int rightIndex) {
        boolean result = false;

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (group[i] != 0) {
                result = true;
            }
        }
        
        return result;
    }

    // Iterates through the array from @leftIndex to @rightIndex, incrementing
    // @instance's test count for each test conducted.
    private void testIndividuals(int[] group, int leftIndex, int rightIndex,
                 MarcusTestCase instance) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            instance.addTests(1);
        }
    }
}
