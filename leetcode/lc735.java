// Simulation with a stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            // We can push a positive asteroid onto the stack without interruption
            if (stack.isEmpty() || i > 0) {
                stack.push(i);
                continue;
            }
            // Killing all the positive asteroids with smaller magnitude
            while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(i)) {
                stack.pop();
            }
            // If there are two negatives, no collision will occur
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(i);
                continue;
            }
            // Both asteroids are killed
            if (stack.peek() == Math.abs(i)) {
                stack.pop();
            }
            
        }
        // Reconstruct result.
        int[] ret = new int[stack.size()];
        for (int i=ret.length-1; i>=0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
