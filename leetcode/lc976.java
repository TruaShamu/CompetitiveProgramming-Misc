import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int answer = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int newPerimeter = works(A[i], A[i + 1], A[i + 2]);
            answer = Integer.max(answer, newPerimeter);
        }
        return answer;
    }

    public static int works(int a, int b, int c) {
        if (a + b > c && b + c > a && a + c > b) {
            return a + b + c;
        } else
            return 0;
    }
}
