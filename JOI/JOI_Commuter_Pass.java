/*
https://oj.uz/problem/view/JOI18_commuter_pass
times out and only gets 24/100 score
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class commuter_pass {
    public static int MAXN = 100000;
    public static int N, M, S, T, U, V;
    public static ArrayList<edge>[] adj = new ArrayList[MAXN];
    public static ArrayList<Integer>[] parent = new ArrayList[MAXN];
    public static ArrayList<Integer>[] dpChildren = new ArrayList[MAXN];
    public static long[] distU = new long[MAXN];
    public static long[] distV = new long[MAXN];
    public static long[] distS = new long[MAXN];
    public static long[] memo = new long[MAXN];
    public static long[] memo2 = new long[MAXN];
    public static boolean[] reachable = new boolean[MAXN];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()) - 1;
        T = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken()) - 1;
        V = Integer.parseInt(st.nextToken()) - 1;
 
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = new ArrayList<>();
            dpChildren[i] = new ArrayList<>();
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new edge(b, c));
            adj[b].add(new edge(a, c));
        }
 
        dijkstra(distU, U);
    /*    for (int i = 0; i < N; i++) {
            System.out.print(distU[i] + " ");
        }
        System.out.println();
 
 
     */
        dijkstra(distV, V);
 
    /*    for (int i = 0; i < N; i++) {
            System.out.print(distV[i] + " ");
        }
        System.out.println();
 
 
     */
 
        dijkstraParent(distS, S);
 
        Arrays.fill(memo, -1);
        Arrays.fill(memo2, -1);
 
        Queue<Integer> q = new LinkedList<>();
        q.add(T);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (!reachable[u]) {
                reachable[u] = true;
                for (int v : parent[u]) {
                    dpChildren[v].add(u);
                    q.add(v);
                }
            }
        }
 
        long ans = distU[V];
        for (int i = 0; i < N; i++) {
            if (reachable[i]) {
                ans = Long.min(ans, distU[i] + Long.min(dp(i), dpBack(i)));
            }
        }
        System.out.println(ans);
    }
 
    public static long dp(int u) {
        if (memo[u] != -1) {
            return memo[u];
        }
        long best = distV[u];
        for (int v : dpChildren[u]) {
            best = Long.min(best, dp(v));
        }
        return memo[u] = best;
    }
 
    public static long dpBack(int u) {
        if (memo2[u] != -1) return memo2[u];
        long best = distV[u];
        for (int v : parent[u]) {
            best = Long.min(best, dpBack(v));
        }
        return memo2[u] = best;
    }
 
 
    public static void dijkstraParent(long[] dist, int source) {
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(source, 0));
 
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            for (edge next : adj[cur.node]) {
                if (dist[next.node] > dist[cur.node] + next.cost) {
                    dist[next.node] = dist[cur.node] + next.cost;
                    parent[next.node].clear();
                    parent[next.node].add(cur.node);
                    pq.add(new edge(next.node, dist[next.node]));
                } else if (dist[next.node] == dist[cur.node] + next.cost) {
                    parent[next.node].add(cur.node);
                }
            }
        }
 
    }
 
    public static void dijkstra(long[] dist, int source) {
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(source, 0));
 
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            for (edge next : adj[cur.node]) {
                if (dist[next.node] > dist[cur.node] + next.cost) {
                    dist[next.node] = dist[cur.node] + next.cost;
                    pq.add(new edge(next.node, dist[next.node]));
                }
            }
        }
    }
 
    static class edge implements Comparable<edge> {
        public int node;
        public long cost;
 
        public edge(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
 
        public int compareTo(edge other) {
            return Long.compare(this.cost, other.cost);
        }
    }
 
 
}
 
