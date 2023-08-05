class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int N = nums.length;
        int[] modFreq = new int[k];
        modFreq[0] = 1;
        int ans = 0;
        int cumulativeMod = 0;
        for (int i=0; i< N; i++) {
            cumulativeMod = ((cumulativeMod + (nums[i] % k) + k) % k);
            System.out.println(cumulativeMod);
            ans += modFreq[cumulativeMod];
            modFreq[cumulativeMod]++;
        }
        
        return ans;
        
    }
}
