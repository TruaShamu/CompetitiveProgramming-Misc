class Solution {
  
        public int maxSatisfaction(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int sum = 0;
        int cur = 0;
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += A[i];
            cur += sum;
            res = Math.max(res, cur);
        }
        return res;
    }
}
