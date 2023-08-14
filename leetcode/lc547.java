class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        int ret = 0;
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        for (int i=0; i< N; i++) {
            if (!visited[i]) {
                ret++;
                dfs(isConnected, visited, i);
            }
        }
        return ret;
    }
    public void dfs(int[][] isConnected, boolean[] visited, int curNode) {
        visited[curNode] = true;
        for (int i=0; i< isConnected.length; i++) {
            if (isConnected[curNode][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
