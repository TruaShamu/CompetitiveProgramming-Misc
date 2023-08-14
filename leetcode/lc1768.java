class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder x = new StringBuilder();
        int i=0;
        for (i=0; i< Math.min(word1.length(), word2.length()); i++) {
            x.append(word1.charAt(i));
            x.append(word2.charAt(i));
        }
        if (word2.length() > word1.length()) {
            for (int j=i; j< word2.length(); j++) {
                x.append(word2.charAt(j));
            }
        }

        if (word2.length() < word1.length()) {
            for (int j=i; j< word1.length(); j++) {
                x.append(word1.charAt(j));
            }
        }
        return x.toString();
    }
}
