public class lc1881 {
    public String maxValue(String s, int x) {
        String res = "";

        if (s.charAt(0) == '-') {
            res += s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) - '0' > x) {
                    res += x;
                    res += (s.substring(i));

                    return res;
                }
                res += (s.charAt(i));
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' < x) {
                    res += x;
                    res += (s.substring(i));
                    return res;
                }
                res += (s.charAt(i));
            }
        }
        return res + x;
    }
}
