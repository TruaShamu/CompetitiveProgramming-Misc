// https://dmoj.ca/problem/ccc16s3 phenomenal reviews
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc16s3 {


    private static int N, M;
    private static ArrayList<Integer>[] edges;
    private static boolean[] isPho;
    private static boolean[] marked;
    private static int[] dist;
    private static int totalDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isPho = new boolean[N];
        marked = new boolean[N];

        //Initialize vector
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        //Read pho
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            isPho[Integer.parseInt(st.nextToken())] = true;
        }

        //Edges
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        //DFS from first pho to prune the tree
        for (int i = 0; i < N; i++) {
            if (isPho[i]) {
                mark(i, -1);
                break;
            }
        }
        // System.out.println("TOTAL DIST" + totalDist);
        //System.out.println("MARKED: " + Arrays.toString(marked));

        //Find dist
        dist = new int[N];
        for (int i = 0; i < N; i++) {
            if (marked[i]) {
                computeDist(i, -1, 0);
                break;
            }
        }

        //MaxIndex is the node with the greatest distance
        int maxIndex = -1;
        for (int i = 0; i < N; i++) {
            if (marked[i] && (maxIndex == -1 || (dist[maxIndex] < dist[i]))) {
                maxIndex = i;
            }
        }


        dist = new int[N];
        computeDist(maxIndex, -1, 0);

        int longestDist = 0;

        for (int i = 0; i < N; i++) {
            longestDist = Math.max(longestDist, dist[i]);
        }

        System.out.println(totalDist - longestDist);

    }

    private static void computeDist(int u, int prev, int depth) {
        dist[u] = depth;
        for (int v : edges[u]) {
            if (v != prev && marked[v]) {
                computeDist(v, u, depth + 1);
            }
        }
    }

    private static void mark(int u, int prev) {
        if (isPho[u]) {
            marked[u] = true;
        }
        for (int v : edges[u]) {
            if (v == prev) {
                continue;
            }
            mark(v, u);
            if (marked[v]) {
                totalDist += 2;
                marked[u] = true;
            }
        }
    }


}
