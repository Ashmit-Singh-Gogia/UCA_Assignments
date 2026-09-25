## Villages and Clinics

### Problem Description

There are `n` villages with known populations, and exactly `k` clinics must be opened among them. Every village must receive at least one clinic.

People from one village may use only the clinics located in that same village. If a village has more than one clinic, its population is divided evenly between those clinics. The goal is to assign the clinics so that the busiest clinic has as few patients as possible.

Given the number of villages, the population of every village, and the total number of clinics, find the smallest achievable maximum patient load. Because the result may not be an integer, display it to two decimal places.

### Input Format

The input contains one or more test cases. For each test case, provide:

1. The number of villages, `n`.
2. The total number of clinics, `k`.
3. `n` population values, one for each village.

The values satisfy the following conditions:

- `1 <= n <= k`
- Every population is non-negative.
- Each village has enough population data specified for it.

### Output Format

For every test case, print the minimum possible value of the largest clinic workload, formatted with exactly two digits after the decimal point.

### Example

#### Input

```text
1
3
5
200 20 50
```

#### Output

```text
66.67
```

#### Explanation

The five available clinics can be assigned as follows:

```text
Village 1: 3 clinics -> 200 / 3 = 66.67 patients per clinic
Village 2: 1 clinic  -> 20 / 1  = 20.00 patients per clinic
Village 3: 1 clinic  -> 50 / 1  = 50.00 patients per clinic
```

The largest workload is therefore `66.67`, and no other valid distribution can reduce that value.

### Suggested Method

This is an optimization problem that can be solved with binary search over the answer. Instead of directly deciding how to distribute the clinics, test whether a proposed maximum workload `limit` is achievable.

For a village with population `P`, the number of clinics needed to keep every clinic at or below `limit` is:

```text
ceil(P / limit)
```

Adding this value for all villages gives the total number of clinics required. The candidate is feasible when that total is no greater than `k`.

The possible answer lies between zero and the largest village population. During each binary-search step:

1. Compute the midpoint of the current interval.
2. Count the clinics required for that midpoint.
3. If the count fits within `k`, save the midpoint and search the lower half.
4. Otherwise, search the upper half.

Since the answer is decimal, use a fixed number of iterations, such as `100`, instead of relying on integer bounds. This provides sufficient precision for printing two decimal places.

### Complexity

If there are `n` villages and `I` binary-search iterations, each feasibility test scans all villages once. The resulting complexity is:

```text
Time:  O(n * I)
Space: O(n)
```

With a constant iteration count, the running time is effectively linear in the number of villages.
