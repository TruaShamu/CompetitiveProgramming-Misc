class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {

        //@todo Sort the rooms with descending size.
        java.util.Arrays.sort(rooms, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(b[1], a[1]);
            }
        });

        int[] ans = new int[rooms.length];

        int qIdx = 0;
        for (int[] oQuery : queries) {
            int minId = -1;
            int minIdDiff = Integer.MAX_VALUE;

            for (int roomIndex = 0; roomIndex < rooms.length; roomIndex++) {

                //The size works.
                if (rooms[roomIndex][1] >= oQuery[1]) {
                    int idDiff = Math.abs(rooms[roomIndex][0] - oQuery[0]);
                    if (idDiff < minIdDiff) {
                        minIdDiff = idDiff;
                        minId = rooms[roomIndex][0];
                    } else {
                        if (idDiff < minIdDiff) {
                            if (minId > rooms[roomIndex][0]) {
                                minId = rooms[roomIndex][0];
                            }
                        }
                    }
                } else {
                    break;
                }
            }

            ans[qIdx++] = minId;
        }
        return ans;
    }
}
