package Heap_Problems.Smallest_Range_Covering_Elements;

import java.util.*;

public class Smallest_Range_Covering_Elements {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[0], e2[0]));
        int k = nums.size(), leftAns = 0, rightAns = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i += 1) {
            pq.add(new int[] { nums.get(i).get(0), i, 0 });
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        while (true) {
            int[] curr = pq.poll();
            int minValue = curr[0], listIndex = curr[1], index = curr[2];
            if (maxValue - minValue < rightAns - leftAns) {
                leftAns = minValue;
                rightAns = maxValue;
            }
            if (index + 1 >= nums.get(listIndex).size())
                return new int[] { leftAns, rightAns };
            maxValue = Math.max(maxValue, nums.get(listIndex).get(index + 1));
            pq.add(new int[] { nums.get(listIndex).get(index + 1), listIndex, index + 1 });
        }
    }
}