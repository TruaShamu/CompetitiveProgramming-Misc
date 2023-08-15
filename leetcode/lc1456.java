class Solution {
    public int maxVowels(String s, int k) {
        // Make a set containing the vowels for easy checking
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int ret = 0;

        int count = 0;
        
        // Initialize sliding window
        for (int i=0; i< k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        ret = Math.max(ret, count);

        for (int i=k; i< s.length(); i++) {
            // right side
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i-k))) {
                count--;
            }
            ret = Math.max(ret, count);
        }
        return ret;

        
    }
}
