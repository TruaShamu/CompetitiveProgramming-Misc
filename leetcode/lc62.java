class Solution {
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
