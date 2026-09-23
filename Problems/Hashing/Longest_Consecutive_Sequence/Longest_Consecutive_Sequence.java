package Hashing.Longest_Consecutive_Sequence;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        int max = 0, n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int el : nums) {
            set.add(el);
        }
        for (int el : set) {
            int c = 0;
            if (!set.contains(el - 1)) {
                while (set.contains(el)) {
                    el++;
                    c++;
                }
                max = Math.max(max, c);
            }
        }
        return max;
    }
}
