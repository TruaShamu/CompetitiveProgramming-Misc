class Solution {
        public static int pivotIndex(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = left.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] == right[i]) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
