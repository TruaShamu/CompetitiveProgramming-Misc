// Prefix sum + suffix sum
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] ret = new int[N];
        Arrays.fill(ret, 1);

        int prefix = 1;

        for (int i=0; i< N; i++) {
            ret[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;
        for (int i=N-1; i>=0; i--) {
            ret[i] *= suffix;
            suffix = suffix * nums[i];
        }
        return ret;
    }
}
