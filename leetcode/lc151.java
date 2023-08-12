class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Stack<String> st = new Stack<>();
        for (String x : words) {
            st.add(x);
        }
        StringBuilder ret = new StringBuilder();
        while (!st.isEmpty()) {
            ret.append(st.pop());
            if (!st.isEmpty()) {
                ret.append(" ");
            }
        }
        return ret.toString();
    }
}
