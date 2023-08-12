import java.util.*;

class Trie {
    // Trie Node
    class Node {
        boolean completeWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    Node root, curr;

    // Store the top 3.
    List<String> resultBuffer;

    // DFS in trie, and get the words.
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3) {
            return;
        }
        if (curr.completeWord) {
            resultBuffer.add(word);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            int letterIdx = (int) (c - 'a');
            if (curr.children.get(letterIdx) != null) {
                dfsWithPrefix(curr.children.get(letterIdx), word + c);
            }
        }
    }
    Trie() {
        root = new Node();
    }

    // Insert word into the trie
    void insert(String word) {
        curr = root;
        for (char curChar : word.toCharArray()) {
            int letterIdx = (int) (curChar - 'a'); // Fix variable name typo
            if (curr.children.get(letterIdx) == null) {
                curr.children.set(letterIdx, new Node());
            }
            curr = curr.children.get(letterIdx);
        }
        curr.completeWord = true; // Fix variable name typo
    }


    List<String> getWordsStartingWith(String prefix) {
        curr = root;
        // Clear the buffer
        resultBuffer = new ArrayList<String>();

        // Do initial search for the prefix to ensure the prefix exists
        for (char c : prefix.toCharArray()) {
            int letterIdx = (int) (c - 'a');
            if (curr.children.get(letterIdx) == null) {
                return resultBuffer;
            }
            curr = curr.children.get(letterIdx);
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
}

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Insert the strings in the trie.
        for (String w : products) {
            trie.insert(w);
        }
        // Expand the prefix every time and grab the words.
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
}
