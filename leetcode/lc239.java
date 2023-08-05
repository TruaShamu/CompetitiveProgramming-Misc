class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] ret = new int[N-k+1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i< N; i++) {
            // Get rid of stuff that's not in the window.
            while (deque.size() > 0 && deque.peek() < (i-k+1)) {
                deque.poll();
            }
            // Items smaller than the RHS are useless. By continually getting rid of everything smaller, you have a decreasing deque.
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);

            if (i >= k-1) {
                // The maximum will be the first item in the window
                ret[idx] = nums[deque.peek()];
                idx++;
            }
            

        }
        return ret;
    }
}
