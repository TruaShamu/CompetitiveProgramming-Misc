class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int ret = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                zeroCount++;
            }
            j++;
            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            ret = Math.max(ret,j-i-1);
        }
        return ret;
    }
}
