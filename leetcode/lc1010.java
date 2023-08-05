class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[61];
        int ans = 0;
        for (int i=0; i< time.length; i++) {
            ans += freq[(600 - time[i]) % 60];
            freq[time[i] % 60]++;
        }

        return ans;
    }
}
