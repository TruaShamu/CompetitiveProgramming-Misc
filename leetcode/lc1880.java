public class lc1880 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String s1 = "";

        for (int i = 0; i < firstWord.length(); i++) {
            s1 +=  (firstWord.charAt(i) - 'a');
        }

        String s2 = "";
        for (int i = 0; i < secondWord.length(); i++) {
            s2 += secondWord.charAt(i) - 'a';
        }

        String s3 = "";
        for (int i = 0; i < targetWord.length(); i++) {
            s3 += targetWord.charAt(i) - 'a';
        }

        if (Integer.parseInt(s1) + Integer.parseInt(s2) == Integer.parseInt(s3)) {
            return true;
        }
        return false;
    }
}

