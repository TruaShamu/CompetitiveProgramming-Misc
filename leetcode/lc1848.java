class Solution {
        public static int getMinDistance(int[] nums, int target, int start) {
                int dist = Integer.MAX_VALUE;
                for (int i=0; i< nums.length; i++) {
                        if (nums[i] == target) {
                             if (Math.abs(i - start) < dist) {
                                     dist = Math.abs(i - start);
                             }
                        }
                }
                return dist;

        }
}
