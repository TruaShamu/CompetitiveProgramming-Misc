import java.io.*;
import java.util.StringTokenizer;

public class matching {
    public static int MOD = (int) 1e9 + 7;
    public static int MAXN = 21;
    public static boolean[][] comp = new boolean[MAXN][MAXN];
    public static int[] dp = new int[1 << MAXN];
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int N = io.nextInt();

        for (int i=0; i< N; i++) {
            for (int j=0; j< N; j++) {
                comp[i][j] = (io.nextInt() == 1);
            }
        }

        dp[0] = 1;
        for (int mask = 0; mask < (1 << N); mask++) {
            int now = N - Integer.bitCount(mask);
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) > 0 && comp[now][i]) {
                    dp[mask] = (dp[mask] + dp[mask ^ (1 << i)]) % MOD;
                }
            }
        }

       System.out.println(dp[(1 << N) - 1]);
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in,System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName+".out"));
            r = new BufferedReader(new FileReader(problemName+".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
