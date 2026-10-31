package Oct31.Minimum_Coins_For_Shopping;

public class Minimum_Coins_For_Shopping {

    /**
     * Calculates the minimum number of coins needed to buy one item from each
     * of the n shops, such that no two consecutive shops have the same item type
     * purchased.
     *
     * @param n     the number of shops
     * @param costs an n x 3 2D array where costs[i][j] is the cost of item j at
     *              shop i
     * @return the minimum total coins required
     */

    /**
     * Recursive helper with memoization to find the minimum cost.
     */
    public static int helper(int[][] costs, int notTake, int i, Integer[][] memo) {
        if (i == costs.length)
            return 0;
        if (notTake != -1 && memo[i][notTake] != null)
            return memo[i][notTake];

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j == notTake)
                continue;
            min = Math.min(min, costs[i][j] + helper(costs, j, i + 1, memo));
        }

        if (notTake != -1) {
            memo[i][notTake] = min;
        }
        return min;
    }

    /**
     * Unmemoized recursive helper (user implementation).
     */
    public static int helper(int[][] costs, int notTake, int i) {
        if (i == costs.length)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j == notTake)
                continue;
            min = Math.min(min, costs[i][j] + helper(costs, j, i + 1));
        }
        return min;
    }

    /**
     * Iterative Bottom-Up DP: O(N) time and O(1) auxiliary space.
     * Prevents StackOverflowError on N up to 10^4.
     */
    public static int minCoinsDP(int n, int[][] costs) {
        if (n <= 0 || costs == null || costs.length == 0)
            return 0;

        int prev0 = costs[0][0];
        int prev1 = costs[0][1];
        int prev2 = costs[0][2];

        for (int i = 1; i < n; i++) {
            int curr0 = costs[i][0] + Math.min(prev1, prev2);
            int curr1 = costs[i][1] + Math.min(prev0, prev2);
            int curr2 = costs[i][2] + Math.min(prev0, prev1);

            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        return Math.min(prev0, Math.min(prev1, prev2));
    }

    public static int minCoins(int n, int[][] costs) {
        return minCoinsDP(n, costs);
    }

    /**
     * Overloaded helper function accepting just the costs array.
     *
     * @param costs an n x 3 2D array of item costs
     * @return the minimum total coins required
     */
    public static int minCoins(int[][] costs) {
        if (costs == null) {
            return 0;
        }
        return minCoins(costs.length, costs);
    }
}
