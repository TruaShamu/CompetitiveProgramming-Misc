public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] pSum = new int[length];
        for (int i=0; i< updates.length; i++) {
            pSum[updates[i][0]] += updates[i][2];
            if (updates[i][1]+1 < length) {
                pSum[updates[i][1]+1] += -1 * updates[i][2];
            }
        }
        for (int i=1; i< length; i++) {
            pSum[i] = pSum[i-1] + pSum[i];
        }
        return pSum;
    }
}
