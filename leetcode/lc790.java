class Solution {
    public int numTilings(int n) {
        // This problem was very annoying -- will write an explanation soon
        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        if (n <= 3) {
            return (int) dp[n];
        }
        for (int i=4; i<=n; i++) {
            dp[i] = 2*dp[i-1] + dp[i-3];
            dp[i] = dp[i] % (int) (1e9 + 7);
        }
        return (int) dp[n];


    }
}
