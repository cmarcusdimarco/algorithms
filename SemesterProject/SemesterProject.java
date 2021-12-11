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
                String tempInt = integers[i];
                integers[i] = integers[randomIndex];
                integers[randomIndex] = tempInt;
            }
        }
    }
    public static void main(String[] args) {
        // Initialize primary variables/data structures
        final int POPULATION = Integer.parseInt(args[0]);
        final double INFECTION_RATE = 0.02;
            // Population size as a constant
        int[] populationArray = new int[POPULATION];
            // Array of population size
        
        // Infect 2% of array
        for (int i = 0; i < (POPULATION * INFECTION_RATE); i++) {
            populationArray[i] = 1;
        }

        // Shuffle array to represent random distribution
        notRosannaShuffle(populationArray);

        // Implement testing of subarrays of size 8
            // Case 1: sum of subarrays is 0
                // Return negative result
            
            // Case 2: sum of subarrays is not 0
                // Test left half and right half
                    // Case 1: sum of one half is 0
                        // Return negative result
                    // Case 2: sum of one half is not 0
                        // Test each element individually, return result

        // Having counted instances of each case, print results
    }
}
