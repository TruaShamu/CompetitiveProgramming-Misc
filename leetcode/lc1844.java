class Solution {
    public String replaceDigits(String s) {
        char[] inp = s.toCharArray();
        for (int i=0; i< s.length(); i++) {
            //Is number
            if (s.charAt(i) >= '0' && s.charAt(i)<='9') {

                int prev = (s.charAt(i-1) - 'a') + (s.charAt(i)-'0');
                inp[i] = (char) (prev + 'a');
            }
        }

        return String.valueOf(inp);

    }
}
