class Solution {

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char currentChar = s[i];
            char newChar = s[s.length - i - 1];
            s[i] = newChar;
            s[s.length - i - 1] = currentChar;

        }
        System.out.println(s);
    }
}
