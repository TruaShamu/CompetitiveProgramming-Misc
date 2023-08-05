class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        // Build a prefix sum array.
        Arrays.sort(nums);
        int[] pSums = new int[nums.length];
        pSums[0] = nums[0];
        for (int i=1; i< nums.length; i++) {
            pSums[i] = pSums[i - 1] + nums[i];
        }

        // Binary search for the first prefix sum <= queries[i].
        // No need to sort because prefix sum is monotonically increasing.

        int[] ans = new int[queries.length];
        for (int i=0; i< queries.length; i++) {
            int idx = Arrays.binarySearch(pSums, queries[i]);
            // Found number in pSums equal to the query.
            if (idx >= 0) {
                ans[i] = idx+1;
            } else {
                // Couldn't find the number in pSums.
                // So we pick the prefix sum closest but smaller than the query.
                ans[i] = -(idx + 1);
            }
        }
        return ans;
    }
}
