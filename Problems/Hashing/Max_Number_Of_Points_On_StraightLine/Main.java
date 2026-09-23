package Hashing.Max_Number_Of_Points_On_StraightLine;

public class Main {
    public static void main(String[] args) {
        Max_Points_On_Line_Brute pointsCalulator = new Max_Points_On_Line_Brute();

        // Test Case 1: Basic — 3 points on y=x, 1 outlier → expected 3
        int[][] tc1 = {{1, 1}, {2, 2}, {3, 3}, {1, 4}};
        System.out.println("Test 1: Expected: 3, Output: " + pointsCalulator.maxPoints(tc1));

        // Test Case 2: All points are the same → expected 4
        int[][] tc2 = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
        System.out.println("Test 2: Expected: 4, Output: " + pointsCalulator.maxPoints(tc2));

        // Test Case 3: Vertical line (x = 2) → expected 4
        int[][] tc3 = {{2, 1}, {2, 5}, {2, -3}, {2, 8}, {0, 0}};
        System.out.println("Test 3: Expected: 4, Output: " + pointsCalulator.maxPoints(tc3));

        // Test Case 4: Horizontal line (y = 3) → expected 3
        int[][] tc4 = {{-1, 3}, {4, 3}, {7, 3}, {2, 5}};
        System.out.println("Test 4: Expected: 3, Output: " + pointsCalulator.maxPoints(tc4));

        // Test Case 5: Multiple slopes — longest line has 4 points on y = x → expected 4
        int[][] tc5 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {1, 2}, {2, 4}, {3, 6}};
        System.out.println("Test 5: Expected: 4, Output: " + pointsCalulator.maxPoints(tc5));

        // Test Case 6: Single point → expected 1
        int[][] tc6 = {{5, 5}};
        System.out.println("Test 6: Expected: 1, Output: " + pointsCalulator.maxPoints(tc6));
    }
}
