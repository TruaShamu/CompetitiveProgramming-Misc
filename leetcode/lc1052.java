class Solution {
    public int maxSatisfied(int[] C, int[] G, int X) {
        int oldC = 0, newC = 0;
        for (int i = 0, window = 0; i < G.length; i++) {
            //Happy already
            if (G[i] == 0) {
                oldC += C[i];
            } else {
                //Add to window
                window += C[i];
            }
            if (i >= X) {
                window -= (G[i - X] * C[i - X]);
            }
            newC = Math.max(window, newC);
        }
        return oldC + newC;
    }
}
