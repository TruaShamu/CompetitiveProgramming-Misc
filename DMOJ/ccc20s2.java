import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc20s2 {
    public static int MAX = 1000005;
    public static ArrayList<Integer>[] vector = new ArrayList[MAX];
    public static boolean[] visited = new boolean[MAX];
    public static int rows, columns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rows = Integer.parseInt(br.readLine());
        columns = Integer.parseInt(br.readLine());
        for (int i = 0; i < MAX; i++) {
            vector[i] = new ArrayList<>();
        }

        for (int i = 1; i <= rows; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= columns; j++) {
                int inp = Integer.parseInt(st.nextToken());
                vector[i * j].add(inp);
            }
        }

        dfs(1);
        System.out.println("no");
    }

    public static void dfs(int x) {
        if (visited[x]) {
            //System.out.println("visited");
            return;
        }
        if (x == rows * columns) {
            System.out.println("yes");
            System.exit(0);
        }
        visited[x] = true;

        for (int i = 0; i < vector[x].size(); i++) {
            //System.out.println("next: " + vector[x].get(i));
            dfs(vector[x].get(i));
        }
    }
}
