class Solution {
    public boolean closeStrings(String word1, String word2) {
        /* Extremely straightforward.
           We need to check if all the 'letters' used are common to both strings.
           Also, we need to check when we create the frequency lists and sort them, are they the same? */
        int[] word1Freq = new int[26];
        int[] word2Freq = new int[26];
        for (int i=0; i< word1.length(); i++) {
            word1Freq[word1.charAt(i) - 'a']++;
        }
        for (int i=0; i< word2.length(); i++) {
            word2Freq[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i< 26; i++) {
            if (word1Freq[i]==0 && word2Freq[i]!=0 || word1Freq[i]!=0 && word2Freq[i]==0) {
                return false;
            }
        }
        
        Arrays.sort(word1Freq);
        Arrays.sort(word2Freq);
        for (int i = 0; i< 26; i++) {
            if (word1Freq[i]!=word2Freq[i]) {
                return false;
            }
        }
        return true;
    }
}
