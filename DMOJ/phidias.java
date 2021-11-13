import java.io.*;
import java.util.*;

public class Phidias {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int W = io.nextInt();
		int H = io.nextInt();
		int N = io.nextInt();

		// DP[i][j] is the minimum wasted space given an i * j rectangle.
		int[][] dp = new int[W + 1][H + 1];

		// In default, all the space on the slab is wasted.
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j <= H; j++) {
				dp[i][j] = i * j;
			}
		}

		// 0 space is wasted if the slab is the same size as plates.
		for (int i = 0; i < N; i++) {
			int x = io.nextInt();
			int y = io.nextInt();
			dp[x][y] = 0;
		}

		/*
		 * Loop through all possible slabs
		 * with width from 1 to w and height from 1 to h.
		 */
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= H; j++) {
				for (int a = 1; a <= i; a++) {
					// Fix the vertical cut to calculate the minimum area wasted.
					dp[i][j] = Math.min(dp[i][j], dp[a][j] + dp[i - a][j]);
				}
				for (int b = 1; b <= j; b++) {
					// Fix the horizontal cut to calculate the minimum area wasted.
					dp[i][j] = Math.min(dp[i][j], dp[i][b] + dp[i][j - b]);
				}
			}
		}
		System.out.println(dp[W][H]);
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
	
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
	
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
	
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
							  
