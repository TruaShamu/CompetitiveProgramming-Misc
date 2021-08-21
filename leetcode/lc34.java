import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(array, target)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] returnArray = new int[2];
        int first = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return new int[]{-1, -1};
        }
        returnArray[0] = first;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                returnArray[1] = i;
                return returnArray;
            }
        }
        return new int[]{-1, -1};

    }
}
