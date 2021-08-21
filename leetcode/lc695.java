class Solution {
    public  int[] dR = new int[]{-1, 0, 0, 1};
    public  int[] dC = new int[]{0, -1, 1, 0};
    public  int[][] grid;
    public  int N, M;
    public  int res = 0, size = 0;

    
    public int maxAreaOfIsland(int[][] a) {
        grid = a;
        N = grid.length;
        M = grid[0].length;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, visited);
                    size = 0;
                }
            }
        }

        return res;

    }

    public void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        size++;
        for (int dir = 0; dir < dR.length; dir++) {
            int nR = i + dR[dir];
            int nC = j + dC[dir];
            if (visitable(nR, nC, visited)) {
                dfs(nR, nC, visited);
            }
        }
        res = Integer.max(res, size);

    }

    public boolean visitable(int i, int j, boolean[][] visited) {
        return (i >= 0 && i < N && j >= 0 && j < M && !visited[i][j] && grid[i][j] == 1);
    }
}
