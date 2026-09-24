package Heap_Problems.Smallest_Range_Covering_Elements;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Smallest_Range_Covering_Elements solution = new Smallest_Range_Covering_Elements();

        // Test 1: Standard case from problem description
        // Expected: [20, 24]
        List<List<Integer>> nums1 = new ArrayList<>();
        nums1.add(Arrays.asList(4, 10, 15, 24, 26));
        nums1.add(Arrays.asList(0, 9, 12, 20));
        nums1.add(Arrays.asList(5, 18, 22, 30));
        System.out.println("Test 1: Expected: [20, 24], Result: " + Arrays.toString(solution.smallestRange(nums1)));

        // Test 2: All identical lists
        // Expected: [1, 1]
        List<List<Integer>> nums2 = new ArrayList<>();
        nums2.add(Arrays.asList(1, 2, 3));
        nums2.add(Arrays.asList(1, 2, 3));
        nums2.add(Arrays.asList(1, 2, 3));
        System.out.println("Test 2: Expected: [1, 1], Result: " + Arrays.toString(solution.smallestRange(nums2)));

        // Test 3: Single element in each list
        // Expected: [1, 3]
        List<List<Integer>> nums3 = new ArrayList<>();
        nums3.add(Arrays.asList(1));
        nums3.add(Arrays.asList(2));
        nums3.add(Arrays.asList(3));
        System.out.println("Test 3: Expected: [1, 3], Result: " + Arrays.toString(solution.smallestRange(nums3)));

        // Test 4: Negative numbers
        // Expected: [-4, -2]
        List<List<Integer>> nums4 = new ArrayList<>();
        nums4.add(Arrays.asList(-5, -3, 0, 4));
        nums4.add(Arrays.asList(-2, 1, 5, 8));
        nums4.add(Arrays.asList(-4, -1, 3, 6));
        System.out.println("Test 4: Expected: [-4, -2], Result: " + Arrays.toString(solution.smallestRange(nums4)));

        // Test 5: Only one list (single list edge case)
        // Expected: [1, 1] (range must cover at least one from each list; smallest
        // single element range)
        List<List<Integer>> nums5 = new ArrayList<>();
        nums5.add(Arrays.asList(1, 5, 10));
        System.out.println("Test 5: Expected: [1, 1], Result: " + Arrays.toString(solution.smallestRange(nums5)));

        // Test 6: Two lists with a common element giving zero-length range
        // Expected: [5, 5]
        List<List<Integer>> nums6 = new ArrayList<>();
        nums6.add(Arrays.asList(1, 5, 10));
        nums6.add(Arrays.asList(3, 5, 12));
        System.out.println("Test 6: Expected: [5, 5], Result: " + Arrays.toString(solution.smallestRange(nums6)));

        // Test 7: Large spread with tight overlap at the start
        // Expected: [1, 3]
        List<List<Integer>> nums7 = new ArrayList<>();
        nums7.add(Arrays.asList(1, 50, 100));
        nums7.add(Arrays.asList(2, 51, 90));
        nums7.add(Arrays.asList(3, 52, 95));
        System.out.println("Test 7: Expected: [1, 3], Result: " + Arrays.toString(solution.smallestRange(nums7)));

    }

}
