public class Solution {
   public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int val = (1 << maximumBit) - 1;
        for (int i = 0; i < nums.length; ++i) {
            res[nums.length - i - 1] = (val ^= nums[i]);
        }
        return res;
    }

}
