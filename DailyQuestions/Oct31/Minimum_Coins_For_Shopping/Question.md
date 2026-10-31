## Minimum Coins for Shopping

### Problem Description

You are shopping from `N` shops in a row, numbered from `0` to `N - 1`.

At each shop `i`, you must buy exactly one item. There are three types of items available at each shop, indexed as `0`, `1`, and `2`. The cost of buying item `j` at shop `i` is given by `costs[i][j]`.

To keep your shopping diverse, you cannot buy the same type of item from two consecutive shops. That is, if you buy item `j` at shop `i`, you cannot buy item `j` at shop `i + 1`.

Find the minimum number of coins you need to spend to shop from all `N` shops.

### Input Format

The first line contains an integer `N`, the number of shops.
The next `N` lines each contain three space-separated integers representing the costs of item 0, item 1, and item 2 at that shop.

### Constraints

- `1 <= N <= 10^4`
- `1 <= costs[i][j] <= 10^4`

### Output Format

Print a single integer representing the minimum number of coins required to shop from all `N` shops.

### Example

#### Input

```text
3
14 2 11
11 14 5
14 3 10
```

#### Output

```text
10
```

#### Explanation

The minimum coin purchase sequence is:

```text
Shop 0: Buy item 1 (cost 2)
Shop 1: Buy item 2 (cost 5)
Shop 2: Buy item 1 (cost 3)
```

Total cost = `2 + 5 + 3 = 10`.

### Suggested Method

This problem is a classic Dynamic Programming problem (equivalent to the *Paint House* problem). A greedy approach fails because choosing the locally cheapest item at one shop may force an expensive item at the next shop.

#### Dynamic Programming Formulation

Let `dp[i][j]` denote the minimum cost to buy items from shop `0` through shop `i`, such that item `j` (`j ∈ {0, 1, 2}`) is chosen at shop `i`.

#### Recurrence Relations

For each shop `i` from `1` to `N - 1`:
- If we choose item `0` at shop `i`, the preceding shop `i - 1` must have chosen item `1` or `2`:
  ```text
  dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
  ```
- If we choose item `1` at shop `i`, the preceding shop `i - 1` must have chosen item `0` or `2`:
  ```text
  dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
  ```
- If we choose item `2` at shop `i`, the preceding shop `i - 1` must have chosen item `0` or `1`:
  ```text
  dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])
  ```

#### Base Cases

For shop `0`, no previous choices exist:
```text
dp[0][0] = costs[0][0]
dp[0][1] = costs[0][1]
dp[0][2] = costs[0][2]
```

#### Space Optimization

Because each shop's DP states depend only on the immediately preceding shop (`i - 1`), we only need three rolling variables:
`prev0`, `prev1`, and `prev2`.
This reduces the auxiliary space complexity from `O(N)` to `O(1)`.

#### Final Result

After processing all `N` shops, the answer is:
```text
min(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2])
```

### Complexity

```text
Time:  O(N)
Space: O(1) auxiliary space
```

- **Time Complexity:** `O(N)` — A single pass across `N` shops with `O(1)` constant operations per shop.
- **Space Complexity:** `O(1)` — Only three variables are needed to store rolling DP states.

