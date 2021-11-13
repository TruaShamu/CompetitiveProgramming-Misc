/*
Times out and only gets score 71/100
Problem statement:https://oj.uz/problem/view/IZhO14_bank

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;
 
public class bank {
    public static int N, M, s, l;
    public static int[] A;
    public static BitSet[] ct = new BitSet[(1 << 20)];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        //@TODO READ SALARY.
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
 
 
        //@TODO READ PAYNOTES
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
 
        ArrayList<Integer>[] sum = new ArrayList[20001];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = new ArrayList<>();
        }
 
        //For each subset of paynotes, find the sum
        for (int mask = 0; mask < (1 << M); ++mask) {
            int cur = 0;
 
            for (int i = 0; i < M; ++i) {
                if ((mask & (1 << i)) > 0) {
                    cur += B[i];
                }
            }
            sum[cur].add(mask);
        }
 
        //Initialize DP
        ArrayList<Integer>[] dp = new ArrayList[N + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(0);
 
 
        boolean answer = false;
        for (int i = 0; i < N; ++i) {
            boolean[] vis = new boolean[1 << M];
            answer = false;
            //for each subset of paynotes that gives the sum
            for (int mask : sum[A[i]]) {
                for (int pmask : dp[i]) {
                    //No intersection between bits, and the union is not used.
                    if ((mask & pmask) <= 0 && !vis[mask | pmask]) {
                        vis[mask | pmask] = true;
                        dp[i + 1].add(mask | pmask);
                        answer = true;
                    }
                }
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}
