class Solution {
    public int minDeletionSize(String[] strs) {
        int N = strs.length;
        int M = strs[0].length();
        int count = 0;
        for (int i=0; i< M; i++) {
            char last = 'a' - 1;
            for (int j=0; j< N; j++) {
                if (strs[j].charAt(i) < last) {
                    count++;
                    break;
                } else {
                    last = strs[j].charAt(i);
                }
            }
        }
        return count;
    }
}
