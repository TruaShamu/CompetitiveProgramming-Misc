public class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int idx = 0;
            int[] ans = new int[queries.length];
            for (int[] query : queries) {
                int cnt = 0;
                for (int[] point : points) {
                    int deltaxsq = Math.abs(point[0] -  query[0]) * Math.abs(point[0] -  query[0]);
                    int deltaysq = Math.abs(point[1] -  query[1]) * Math.abs(point[1] -  query[1]);
                    if (deltaysq + deltaxsq <= (query[2] * query[2])) {
                        cnt++;
                    }
                }
                ans[idx] = cnt;
                idx++;

            }
            return ans;
        }

}
