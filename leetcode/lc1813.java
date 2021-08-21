class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        //Keep 1 longer than 2/
        if (sentence1.length () < sentence2.length()) {
            return areSentencesSimilar (sentence2, sentence1);
        }

        String[] sent1 = sentence1.split(" ");
        String[] sent2 = sentence2.split(" ");

        int i=0;
        int j = sent1.length - 1;
        int k = sent2.length - 1 ;

        while (i< sent2.length && sent1[i].equals(sent2[i])) {
            i++;
        }

        while (k>=0 && sent1[j].equals(sent2[k])) {
            j--;
            k--;
        }

        return (i>k);




    }
}
