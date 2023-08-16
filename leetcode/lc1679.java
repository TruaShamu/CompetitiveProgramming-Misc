class Solution {
    public int maxOperations(int[] nums, int k) {
        int ret = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            if (freq.containsKey(k-i)) {
                if (freq.get(k-i) > 1) {
                    freq.put(k-i, freq.get(k-i)-1);
                } else {
                    freq.remove(k-i);
                }
                ret++;
            } else {
                if (freq.containsKey(i)) {
                    freq.put(i, freq.get(i)+1);
                } else {
                    freq.put(i, 1);
                }
            }
        }
        return ret;

    }
}
