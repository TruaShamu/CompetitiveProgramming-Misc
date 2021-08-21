class Solution {
public static int minMoves(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        //Indexes of all 1's
        ArrayList<Integer> ones = new ArrayList<>();
        ones.add(0);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones.add(i);
            }
        }
        System.out.println(ones);

        //Make prefix sum
        int[] prefix = new int[ones.size()];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + ones.get(i);
        }
        System.out.println(Arrays.toString(prefix));


        int ans = Integer.MAX_VALUE;
        int radius = (k - 1) / 2;
        for (int i = 1; i <= ones.size() - k; i++) {

            int midIndex = i + radius; //median
            int leftCost = prefix[midIndex - 1] - prefix[i - 1];
            int rightCost = prefix[i + k - 1] - prefix[midIndex];
            int totalCost = rightCost - leftCost - ((k % 2 == 0) ? ones.get(midIndex) : 0);
            ans = Math.min(ans, totalCost);

        }

        ans -= radius * (radius + 1);
        if (k % 2 == 0) {
            ans -= k / 2;
        }
        return ans;


    }
}
