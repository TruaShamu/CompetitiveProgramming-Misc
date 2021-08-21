class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        if (N == 0) {
            return 0;
        }
        Stack<Integer[]> stack = new Stack<>(); //START X, HEIGHT
        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            int start = i;
            while (!stack.empty() && heights[i] < stack.peek()[1]) {
                Integer[] cur = stack.peek();
                stack.pop();
                start = cur[0];
                maxArea = Integer.max(maxArea, (i - cur[0]) * cur[1]);
            }
            stack.push(new Integer[]{start, heights[i]}); //LENGTH 1 RECTANGLE
        }
        while (!stack.empty()) {
            Integer[] cur = stack.peek();
            stack.pop();
            maxArea = Integer.max(maxArea, (N - cur[0]) * cur[1]);
        }
        return maxArea;
    }
}
