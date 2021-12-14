/**
 * A program which simulates group/pooled testing on a population of 1000,
 * 10,000, 100,000 and 1,000,000 people for a disease with a 2% infection
 * rate and a test accuracy of 100%. Testing is in groups of 8 and should
 * account for 3 possible cases: 0 infections, 1 infection, or 2+ infections
 * in the group.
 */

// Import necessary libraries

public class SemesterProject {
    // A modified implementation of notRosannaShuffle() to shuffle
    // an array of integers instead of Strings
    public static void notRosannaShuffle(int[] integers) {

        for (int i = integers.length - 1; i >= 0; i--) {
            // Get random index in the remaining length
            int randomIndex = (int) Math.floor(Math.random() * i);
            if (randomIndex == i) {
                continue;
            } else {
                // If the random index is not i, swap their values
                int tempInt = integers[i];
                integers[i] = integers[randomIndex];
                integers[randomIndex] = tempInt;
            }
        }
    }
    public static void main(String[] args) {
        // Initialize primary variables/data structures
        final int POPULATION = Integer.parseInt(args[0]);
            // Population size as a constant
        final double INFECTION_RATE = 0.02;
            // Infection rate as a constant
        final int POOL_SIZE = 8;
            // Pool size to be tested as a constant
        final int NUM_POOLS = POPULATION / POOL_SIZE;
            // Number of pools as a constant
        int[] populationArray = new int[POPULATION];
            // Array of population size
        MarcusTester tester = new MarcusTester();
            // Tester object
        
        // Infect 2% of array
        for (int i = 0; i < (POPULATION * INFECTION_RATE); i++) {
            populationArray[i] = 1;
        }

        // Shuffle array
        notRosannaShuffle(populationArray);

        // Case 1: Pool of 8 tests negative
        MarcusTestCase case1 = new MarcusTestCase();
        // Case 2: Pool of 8 positive, 1/2 subarrays infected
        MarcusTestCase case2 = new MarcusTestCase();
        // Case 3: Pool of 8 positive, 2/2 subarrays infected
        MarcusTestCase case3 = new MarcusTestCase();

        MarcusTestCase[] cases = {
            case1, case2, case3
        };

        // Test
        for (int i = 0; i < populationArray.length; i += POOL_SIZE) {
            tester.test(cases, populationArray, i, i + POOL_SIZE - 1);
        }

        // Having counted instances of each case, print results
        int caseNumber = 1;
        int sumTests = 0;
        String resultString;
            // Using String concatenation to print results in order to
            // track max String length for better formatting of
            // dashed line separator
        int stringMaxLength = 0;
        for (int i = 0; i < cases.length; i++) {
            resultString = "";
            resultString += "Case (" + caseNumber + "): ";
            resultString += NUM_POOLS + " x ";
            resultString += String.format("%.4f", cases[i].getPercentage(NUM_POOLS));
            resultString += " = ";
            resultString += String.format("%3s", cases[i].getCases());
            resultString += " instances requiring " + cases[i].getTests() +
                            " tests";
            System.out.println(resultString);
            if (resultString.length() > stringMaxLength) {
                stringMaxLength = resultString.length();
            }
            caseNumber++;
            sumTests += cases[i].getTests();
        }

        // Print dashed line separator based on max String length above
        for (int i = 0; i < stringMaxLength; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Print conclusion
        System.out.println(sumTests + " tests to screen a population of " +
                           POPULATION +
                           " people for a disease with an infection rate of " +
                           ((int) (INFECTION_RATE * 100)) +"%");
    }
}
