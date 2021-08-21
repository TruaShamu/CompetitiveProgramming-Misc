We can use dynamic programming to solve this problem by making a matrix DP[m][n].
In the DP matrix, DP[i][j] is the number of ways to get to point (i, j).
We can set DP[0][0] to 1, because we start at point (0, 0).

Since the robot can only move down or right, then for each point (i, j), there are 2 parts of DP[i][j].

1. The number of ways you can reach (i, j) by moving down from point (i-1, j).
2. The number of ways you can reach (i, j) by moving right from point (i, j-1).
Therefore, we can say that:

dp[0][j] = dp[0][j - 1] for j > 0.
dp[i][0] = dp[i - 1][0] for i > 0.
dp[i][j] = dp[i - 1][j] + dp[i][j - 1] for i>0 & j>0.

Final complexity: O (M * N)



```
public class Solution {
    public int uniquePaths(int m, int n) {
        //dp[i][j] means: number of ways to get to point (i, j) on the grid.
        int[][] dp = new int[m][n];

        //We start at point (0,0), so dp[0][0] = 1.
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //Add in all the ways of getting to (i)(j) from walking down from the point (i-1)(j).
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                //Add in all the ways of getting to (i)(j) from walking right from the point (i)(j-1).
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        //The final answer.
        return dp[m - 1][n - 1];
    }
}
```
