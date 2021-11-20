import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class birthday {
    public static boolean[][] edges;
    public static ArrayList<Edge> edgeList;
    public static boolean[] visited;
    public static int n, m;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileWriter("birthday.out"));
        String s;
        while (!(s = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            edges = new boolean[n][n];
            visited = new boolean[n];
            edgeList = new ArrayList<>();
            solve();

        }
    }

    public static void dfs(int node) {
        //Visit all visitable nodes
        visited[node] = true;
        for (int to = 0; to < n; to++) {
            if (edges[node][to] && !visited[to]) {
                dfs(to);
            }
        }

    }

    public static void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            //Add nodes to list
            edges[node1][node2] = true;
            edges[node2][node1] = true;
            edgeList.add(new Edge(node1, node2));
        }

        for (Edge x : edgeList) {
            //Remove the edge
            edges[x.node1][x.node2] = false;
            edges[x.node2][x.node1] = false;
            Arrays.fill(visited, false);
            dfs(0);
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    //Now we can't reach all the nodes
                    System.out.println("Yes");
                    return;
                }
            }
            edges[x.node1][x.node2] = true;
            edges[x.node2][x.node1] = true;
        }
        System.out.println("No");

    }

}

class Edge {
    public int node1, node2;

    public Edge(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}
