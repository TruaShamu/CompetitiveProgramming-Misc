class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()) {
                continue;
            }
            System.out.println(stack.peek());
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.append(stack.pop());
        }
        return ret.reverse().toString();
    }
}
