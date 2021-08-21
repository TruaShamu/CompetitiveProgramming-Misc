class Solution {
public int minDistance (String a, String b) {
        int N = a.length();
        int M = b.length();
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            if (a.charAt(i) == b.charAt(0)) {
                dp[i][0] = 1;
            }
            if (i != 0) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            }
        }

        for (int i = 0; i < M; i++) {
            if (a.charAt(0) == b.charAt(i)) {
                dp[0][i] = 1;
            }
            if (i != 0) {
                dp[0][i] = Math.max(dp[0][i], dp[0][i - 1]);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs =dp[N-1][M-1];
        return (N-lcs ) + (M - lcs);
    }
}
