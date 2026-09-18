package Week3.Count_Inversions_In_Array;

import java.util.*;

public class count_inversions {
    static int pairs = 0;

    public static int count_Pairs(int[] nums, int s, int mid, int e) {
        int i = s, j = mid + 1;
        int localPairs = 0;
        while (i <= mid && j <= e) {
            if (nums[i] > nums[j]) {
                localPairs += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        return localPairs;
    }

    public static void merge(int[] nums, int s, int m, int e) {
        int i = s, j = m + 1, k = 0;
        int[] mix = new int[e - s + 1];
        while (i <= m && j <= e) {
            if (nums[i] < nums[j]) {
                mix[k] = nums[i];
                i++;
            } else {
                mix[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            mix[k++] = nums[i++];
        }

        while (j <= e) {
            mix[k++] = nums[j++];
        }

        for (int idx = s; idx <= e; idx++) {
            nums[idx] = mix[idx - s];
        }

    }

    public static void mergeSort(int[] nums, int s, int e) {
        if (s >= e)
            return;
        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);

        pairs += count_Pairs(nums, s, mid, e);
        merge(nums, s, mid, e);
    }

    public static int countInversions(int[] arr) {
        pairs = 0;
        mergeSort(arr, 0, arr.length - 1);
        return pairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] testCase1 = new int[] { 4, 3, 2, 1 }; // 6
        int[] testCase2 = new int[] { 1, 2, 3, 4 }; // 0
        int[] testCase3 = new int[] { 2, 4, 1, 3, 5 }; // 3
        int[] testCase4 = new int[] { 5, 2, 6, 1, 2 }; // 6
        int[] testCase5 = new int[] { 1, 2, 4, 1, 3, 5 }; // 3

        System.out.printf("Expected : %d , Actual Output : %d\n", 6, countInversions(testCase1));
        System.out.printf("Expected : %d , Actual Output : %d\n", 0, countInversions(testCase2));
        System.out.printf("Expected : %d , Actual Output : %d\n", 3, countInversions(testCase3));
        System.out.printf("Expected : %d , Actual Output : %d\n", 6, countInversions(testCase4));
        System.out.printf("Expected : %d , Actual Output : %d\n", 3, countInversions(testCase5));
    }
}

/*
 * 
 * Given an array of integers arr[]. You have to find the Inversion Count of the
 * array. Inversion count is the number of pairs of elements (i, j) such that i
 * < j and arr[i] > arr[j].
 * 
 * 
 * 
 */