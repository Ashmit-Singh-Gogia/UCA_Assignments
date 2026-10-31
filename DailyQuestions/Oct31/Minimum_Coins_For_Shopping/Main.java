package Oct31.Minimum_Coins_For_Shopping;

import java.util.Scanner;

public class Main {

        /**
         * Finds the minimum coins needed to buy items from all n shops
         * without picking the same item type from two consecutive shops.
         *
         * @param n     number of shops
         * @param costs n x 3 array of item costs
         * @return minimum coins required
         */
        public static int minCoins(int n, int[][] costs) {
                return Minimum_Coins_For_Shopping.minCoins(n, costs);
        }

        public static void main(String[] args) {
                // If run with --stdin or -i argument, read from standard input (competitive
                // programming mode)
                if (args.length > 0 && (args[0].equals("--stdin") || args[0].equals("-i"))) {
                        Scanner sc = new Scanner(System.in);
                        if (!sc.hasNextInt())
                                return;
                        int n = sc.nextInt();
                        int[][] costs = new int[n][3];
                        for (int i = 0; i < n; i++) {
                                costs[i][0] = sc.nextInt();
                                costs[i][1] = sc.nextInt();
                                costs[i][2] = sc.nextInt();
                        }
                        System.out.println(minCoins(n, costs));
                        return;
                }

                // Test Suite: Comprehensive test cases with Expected vs Result

                // Test 1: Example from problem description
                // 3 shops -> [14, 2, 11], [11, 14, 5], [14, 3, 10]
                // Shop 0: item 1 (2), Shop 1: item 2 (5), Shop 2: item 1 (3) -> 10
                int[][] test1 = {
                                { 14, 2, 11 },
                                { 11, 14, 5 },
                                { 14, 3, 10 }
                };
                System.out.printf("Test 1: Expected: 10, Result: %d%n",
                                minCoins(test1.length, test1));

                // Test 2: Single shop, single optimal item
                // 1 shop [17, 2, 17] -> 2
                int[][] test2 = {
                                { 17, 2, 17 }
                };
                System.out.printf("Test 2: Expected: 2, Result: %d%n",
                                minCoins(test2.length, test2));

                // Test 3: Two shops with strict alternation
                // Shop 0: item 0 (1), Shop 1: item 1 (2) -> 3
                int[][] test3 = {
                                { 1, 2, 3 },
                                { 1, 2, 3 }
                };
                System.out.printf("Test 3: Expected: 3, Result: %d%n",
                                minCoins(test3.length, test3));

                // Test 4: Greedy trap
                // Locally picking min at shop 0 (item 0 cost 2) forces cost 100 at shop 1
                // (total 102)
                // Choosing item 1 at shop 0 (cost 100) allows cost 1 at shop 1 (total 101)
                int[][] test4 = {
                                { 2, 100, 100 },
                                { 1, 100, 100 }
                };
                System.out.printf("Test 4: Expected: 101, Result: %d%n",
                                minCoins(test4.length, test4));

                // Test 5: Identical costs across all items and shops
                // 3 shops, all 5s -> 5 + 5 + 5 = 15
                int[][] test5 = {
                                { 5, 5, 5 },
                                { 5, 5, 5 },
                                { 5, 5, 5 }
                };
                System.out.printf("Test 5: Expected: 15, Result: %d%n",
                                minCoins(test5.length, test5));

                // Test 6: Diagonal alternating path
                // Shop 0: item 2 (2), Shop 1: item 0 (3), Shop 2: item 2 (2), Shop 3: item 0
                // (2) -> 9
                int[][] test6 = {
                                { 7, 6, 2 },
                                { 3, 8, 9 },
                                { 10, 5, 2 },
                                { 2, 9, 8 }
                };
                System.out.printf("Test 6: Expected: 9, Result: %d%n",
                                minCoins(test6.length, test6));

                // Test 7: Multi-shop sequence with varied costs (5 shops)
                // Optimal sequence cost -> 23
                int[][] test7 = {
                                { 17, 2, 17 },
                                { 16, 16, 5 },
                                { 14, 3, 19 },
                                { 12, 18, 7 },
                                { 6, 10, 20 }
                };
                System.out.printf("Test 7: Expected: 23, Result: %d%n",
                                minCoins(test7.length, test7));

                // Test 8: Multiple equal optimal paths
                // 2 shops of all 10s -> 10 + 10 = 20
                int[][] test8 = {
                                { 10, 10, 10 },
                                { 10, 10, 10 }
                };
                System.out.printf("Test 8: Expected: 20, Result: %d%n",
                                minCoins(test8.length, test8));
        }
}
