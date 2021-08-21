class Solution {
    public int climbStairs(int N) {
        int[] dp = new int[50];
        dp[1] = 1;
        dp[2] = 2;
        if (N <= 2) {
            return dp[N];
        }
        for (int i = 3; i <= N; i++) {
            if (i - 1 > 0) {
                dp[i] += (dp[i - 1]);
            }

            if (i - 2 > 0) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[N];
    }
}
