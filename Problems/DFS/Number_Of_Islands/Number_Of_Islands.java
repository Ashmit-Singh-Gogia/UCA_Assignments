package DFS.Number_Of_Islands;

public class Number_Of_Islands {

    /**
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's
     * (water),
     * return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically. You may assume all four edges of the grid are all
     * surrounded by water.
     *
     * @param grid 2D grid of '1's and '0's
     * @return total number of islands
     */

    int[] dRow = new int[] { -1, 1, 0, 0 };
    int[] dCol = new int[] { 0, 0, 1, -1 };

    int rows = 0, cols = 0;

    public boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }

    public void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '#';
        for (int i = 0; i < 4; i++) {
            int row = r + dRow[i], col = c + dCol[i];
            if (isValid(row, col) && grid[row][col] == '1') {
                dfs(grid, row, col);
            }
        }
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }
}
