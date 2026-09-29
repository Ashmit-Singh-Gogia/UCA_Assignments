## Number of Islands

### Problem Description

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are surrounded by water.

---

### Input Format

- A 2D array of characters `grid` of size `m x n`, where each element is either `'1'` (land) or `'0'` (water).

### Output Format

- An integer representing the total count of distinct islands.

---

### Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`.

---

### Examples

#### Example 1

**Input:**
```text
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```

**Output:**
```text
1
```

#### Example 2

**Input:**
```text
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```

**Output:**
```text
3
```

---

### Suggested Methods

1. **Depth-First Search (DFS)**:
   - Iterate through every cell `(i, j)` in the grid.
   - When encountering a `'1'`, increment the island counter and launch a DFS traversal to mark all 4-directionally adjacent `'1'`s as visited (e.g., mutate to `'0'` or use a visited array).
   - Continue until the entire grid is scanned.

2. **Breadth-First Search (BFS)**:
   - Similar to DFS, but use a queue to explore all connected land cells level-by-level starting from each unvisited `'1'`.

3. **Disjoint Set Union (DSU / Union-Find)**:
   - Treat each `'1'` as an individual node and union adjacent land cells. The number of connected components of land cells gives the total island count.

---

### Complexity

- **Time Complexity:** $O(m \times n)$, where $m$ is the number of rows and $n$ is the number of columns, because every cell is visited a constant number of times.
- **Space Complexity:** $O(m \times n)$ in the worst case (for the recursion stack or BFS queue if the entire grid is filled with lands).
