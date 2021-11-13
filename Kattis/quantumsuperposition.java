import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quantumsuperposition {
    public static int MAX = 2005;
    public static ArrayList<Integer>[] adj1, adj2;
    public static boolean[][] visited;
    public static int N1, M1, N2, M2;
    public static ArrayList<Integer> finish1, finish2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        M1 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());
        finish1 = new ArrayList<>();
        finish2 = new ArrayList<>();
        visited = new boolean[MAX][MAX];
        adj1 = new ArrayList[N1];
        for (int i = 0; i < N1; i++) {
            adj1[i] = new ArrayList<>();
        }
        adj2 = new ArrayList[N2];
        for (int i = 0; i < N2; i++) {
            adj2[i] = new ArrayList<>();
        }
        for (int i = 0; i < M1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj1[a].add(b);
        }

        for (int i = 0; i < M2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj2[a].add(b);
        }
        dfs1(0, 0);
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        dfs2(0, 0);
        //System.out.println("FINISH1: " + finish1);
        //System.out.println("FINISH2: " + finish2);
        //System.out.println("TOTAL SIZE: " + (finish1.size() + finish2.size()));
        boolean[] ans = new boolean[2 * MAX];
        for (int i = 0; i < finish1.size(); i++) {
            for (int j = 0; j < finish2.size(); j++) {
                //System.out.println("VALUE: " + (finish1.get(i) + finish2.get(j)));
                ans[finish1.get(i) + finish2.get(j)] = true;
            }
        }

        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i++) {
            int inp = Integer.parseInt(br.readLine());
            if (ans[inp]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

    public static void dfs1(int node, int step) {
        if (node == N1 - 1) {
            finish1.add(step);
        }
        visited[node][step] = true;
        for (int next : adj1[node]) {
            if (!visited[next][step + 1]) {
                visited[next][step + 1] = true;
                dfs1(next, step + 1);
            }
        }

    }

    public static void dfs2(int node, int step) {
        if (node == N2 - 1) {
            finish2.add(step);
        }
        visited[node][step] = true;
        for (int next : adj2[node]) {
            if (!visited[next][step + 1]) {
                visited[next][step + 1] = true;
                dfs2(next, step + 1);
            }
        }
    }

}
