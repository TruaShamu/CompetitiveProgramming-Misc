public class Solution {

    public int findLengthOfLCIS(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return len;
        }
        int res = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            maxLen = arr[i] > arr[i - 1] ? maxLen + 1 : 1;
            res = Math.max(res, maxLen);
        }
        return res;
    }
}
