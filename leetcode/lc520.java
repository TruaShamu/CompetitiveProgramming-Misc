class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean capital = false;
        if (!lc(word.charAt(0))) {
            capital = true;
        }
        if (!capital && !lc(word.charAt(1))) {
            return false;
        }
        if (lc(word.charAt(1))) {
            capital = false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (!capital && !lc(word.charAt(i))) {
                return false;
            }
            
            if (capital && lc(word.charAt(i))) {
                return false;
            }

        }
        return true;
    }

    boolean lc(char oChar) {
        return ('a' <= oChar && oChar <= 'z');
    }
}
