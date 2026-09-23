package Hashing.Longest_Consecutive_Sequence;

public class Main {
    public static void main(String[] args) {
        Longest_Consecutive_Sequence solver = new Longest_Consecutive_Sequence();

        // Test Case 1: Basic consecutive sequence → expected 4
        int[] tc1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Test 1: Expected: 4, Output: " + solver.longestConsecutive(tc1));

        // Test Case 2: Longer consecutive with duplicates → expected 9
        int[] tc2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Test 2: Expected: 9, Output: " + solver.longestConsecutive(tc2));

        // Test Case 3: Empty array → expected 0
        int[] tc3 = {};
        System.out.println("Test 3: Expected: 0, Output: " + solver.longestConsecutive(tc3));

        // Test Case 4: Single element → expected 1
        int[] tc4 = { 42 };
        System.out.println("Test 4: Expected: 1, Output: " + solver.longestConsecutive(tc4));

        // Test Case 5: Negative numbers — [-3,-2,-1,0,1] → expected 5
        int[] tc5 = { -3, 10, -1, 0, 1, -2 };
        System.out.println("Test 5: Expected: 5, Output: " + solver.longestConsecutive(tc5));

        // Test Case 6: All duplicates → expected 1
        int[] tc6 = { 5, 5, 5, 5 };
        System.out.println("Test 6: Expected: 1, Output: " + solver.longestConsecutive(tc6));
    }
}
