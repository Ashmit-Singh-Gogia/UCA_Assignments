package Week3.Count_Smaller_After_Self;

import java.util.*;

public class count_smaller_after_self {

    public static int countSmaller(int[] arr) {

    }

    public static void main(String[] args) {
        int[] testCase1 = new int[] { 5, 2, 6, 1 };
        int[] testCase2 = new int[] { -1 };
        int[] testCase3 = new int[] { -1, -1 };
        System.out.printf("Input: %s , Actual Output : %s\n", Arrays.toString(testCase1), countSmaller(testCase1));
        System.out.printf("Input: %s , Actual Output : %s\n", Arrays.toString(testCase2), countSmaller(testCase2));
        System.out.printf("Input: %s , Actual Output : %s\n", Arrays.toString(testCase3), countSmaller(testCase3));
    }
}