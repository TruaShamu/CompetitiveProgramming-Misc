class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (int i=0; i< sentence.length(); i++) {
            char cur = sentence.charAt(i);
            arr[cur - 'a']++;
        }

        int cnt = 0;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] >0) {
                cnt++;
            }
        }

        return cnt == 26;
    }
}
