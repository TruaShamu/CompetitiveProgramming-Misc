import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(s);
        for (int i=0; i< pattern.length(); i++) {
            char oChar = pattern.charAt(i);
            if (!st.hasMoreTokens()) {
                return false;
            }
            String oWord = st.nextToken();
            if (!map.containsKey(oChar)) {
                if (map.containsValue(oWord)) {
                    return false;
                }
                map.put(oChar, oWord);
            } else {
                if (!map.get(oChar).equals(oWord)) {
                    return false;
                }
            }
        }
        if (st.hasMoreTokens()) {
            return false;
        }
        return true;
    }
    
}
