package DFS.Number_Of_Islands;

public class Main {

    public static void main(String[] args) {
        Number_Of_Islands solution = new Number_Of_Islands();

        // Test 1: Standard single large connected island
        // Expected: 1
        char[][] grid1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.printf("Test 1: Expected: 1, Result: %d%n", solution.numIslands(grid1));

        // Test 2: Multiple distinct islands
        // Expected: 3
        char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.printf("Test 2: Expected: 3, Result: %d%n", solution.numIslands(grid2));

        // Test 3: Checkerboard / Diagonals only (diagonal connectivity does not count)
        // Expected: 5
        char[][] grid3 = {
                { '1', '0', '1' },
                { '0', '1', '0' },
                { '1', '0', '1' }
        };
        System.out.printf("Test 3: Expected: 5, Result: %d%n", solution.numIslands(grid3));

        // Test 4: All water (no land cells)
        // Expected: 0
        char[][] grid4 = {
                { '0', '0', '0' },
                { '0', '0', '0' },
                { '0', '0', '0' }
        };
        System.out.printf("Test 4: Expected: 0, Result: %d%n", solution.numIslands(grid4));

        // Test 5: All land (one giant island covering the entire grid)
        // Expected: 1
        char[][] grid5 = {
                { '1', '1', '1' },
                { '1', '1', '1' },
                { '1', '1', '1' }
        };
        System.out.printf("Test 5: Expected: 1, Result: %d%n", solution.numIslands(grid5));

        // Test 6: Single cell edge cases (1x1 land grid and 1x1 water grid)
        // Expected: 1
        char[][] grid6a = {
                { '1' }
        };
        // Expected: 0
        char[][] grid6b = {
                { '0' }
        };
        System.out.printf("Test 6 (1x1 Land): Expected: 1, Result: %d%n", solution.numIslands(grid6a));
        System.out.printf("Test 6 (1x1 Water): Expected: 0, Result: %d%n", solution.numIslands(grid6b));

        // Test 7: 1D grid (1 x 6 row grid with alternating land & water)
        // Expected: 3
        char[][] grid7 = {
                { '1', '0', '1', '1', '0', '1' }
        };
        System.out.printf("Test 7: Expected: 3, Result: %d%n", solution.numIslands(grid7));

        // Test 8: Island enclosing an inner lake with a separate inner island (Donut
        // shape)
        // Expected: 2
        char[][] grid8 = {
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '0', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '1' },
                { '1', '1', '1', '1', '1' }
        };
        System.out.printf("Test 8: Expected: 2, Result: %d%n", solution.numIslands(grid8));
    }
}
