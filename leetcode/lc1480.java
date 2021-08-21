class Solution {
public int[] runningSum(int[] nums) {
        int[] pS = new int[nums.length];
        pS[0] = nums[0];
        for (int i=1; i< nums.length; i++) {
            pS[i]= pS[i-1] + nums[i];
        }
        
        return pS;

    }
}
