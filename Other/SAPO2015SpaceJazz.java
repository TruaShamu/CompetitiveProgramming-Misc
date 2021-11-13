import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jazz {
    public static int MAXN = 505;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray(); //Input array.

        int[][] dp = new int[MAXN][MAXN];
        for (int j = 0; j <= A.length; j++) {
            for (int i = 0; i < A.length - j; i++) {
                dp[i][i + j] = dp[i + 1][i + j] + 1; //Update DP.
                for (int k = i + 1; k <= (i + j); k++) {
                    //2 matching elements.
                    if (A[k] == A[i]) {
                        //l=i, r=i+j (j window) = min(original, (i+1, k-1) + (k+1, i+j)
                        dp[i][i + j] = Integer.min(dp[i][i + j], dp[i + 1][k - 1] + dp[k + 1][i + j]);
                    }
                }
            }
        }

        System.out.println(dp[0][A.length - 1]);
    }

}
