package Week3.Count_Reverse_Pairs;

import java.util.*;

public class count_reverse_pairs {
    static int pairs = 0; // counts the reverse pairs

    public static int count_Pairs(int[] nums, int s, int mid, int e) {
        int i = s, j = mid + 1;
        int localPairs = 0;
        while (i <= mid && j <= e) {
            if (nums[i] > 2 * nums[j]) {
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

    public static int reversePairs(int[] arr) {
        pairs = 0;
        mergeSort(arr, 0, arr.length - 1);
        return pairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] testCase1 = new int[] { 1, 3, 2, 3, 1 };
        int[] testCase2 = new int[] { 2, 4, 3, 5, 1 };
        System.out.printf("Expected : %d , Actual Output : %d\n", 2, reversePairs(testCase1));
        System.out.printf("Expected : %d , Actual Output : %d\n", 3, reversePairs(testCase2));
    }
}

/*
 * 
 * 0 <= i < j < n
 * nums[i] > 2 * nums[j]
 * 
 */