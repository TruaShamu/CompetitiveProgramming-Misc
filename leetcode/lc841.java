class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        dfs(rooms, 0, visited);
        for (int i = 0; i< N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int curNode, boolean[] visited) {
        visited[curNode] = true;
        for (int i: rooms.get(curNode)) {
            if (!visited[i]) {
                dfs(rooms, i, visited);
            }
        }
    }

}
