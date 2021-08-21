class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(sum+=nums[i], max);
            sum = Math.max(sum, 0);
        }
    return max;
    }
}
