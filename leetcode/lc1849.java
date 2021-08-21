class Solution {
    public static boolean splitString(String S) {
        return isValid(S, null);
    }

    private static boolean isValid(String S, Long prev) {
        int N = S.length();
        long cur = 0;
        for (int i = 0; i < N; i++) {

            cur = (cur * 10) + (S.charAt(i) - '0');

            if (prev == null) {
                if (isValid(S.substring(i + 1), cur)) {
                    return true;
                }
            } else if (cur == prev - 1 && (i == N - 1 || isValid(S.substring(i + 1), cur))) {
                return true;
            }
        }
        return false;
    }
}
