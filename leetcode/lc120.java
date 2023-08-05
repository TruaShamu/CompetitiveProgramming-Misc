class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        for (int row = N - 2; row >= 0; row--) {
            for (int cell = 0; cell < triangle.get(row).size(); cell++) {
                int curVal = Integer.MAX_VALUE;
                curVal = Math.min(curVal, triangle.get(row+1).get(cell) + triangle.get(row).get(cell));
                curVal = Math.min(curVal, triangle.get(row+1).get(cell + 1) + triangle.get(row).get(cell));
                triangle.get(row).set(cell, curVal);                 
            }
        }

        return triangle.get(0).get(0);

    }
}
