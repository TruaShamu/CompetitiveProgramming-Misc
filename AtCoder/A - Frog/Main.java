import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		Arrays.fill(dp, (int) 1e9);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i - 1] + Math.abs(A[i] - A[i - 1]));
			}
			if (i > 1) {
				dp[i] = Math.min(dp[i], dp[i - 2] + Math.abs(A[i] - A[i - 2]));
			}
		}

		System.out.println(dp[N - 1]);
	}
}
