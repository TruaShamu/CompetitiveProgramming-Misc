class TrieNode {
    // Is this trie node completing a word
    boolean completeWord;
    // The children of the node.
    TrieNode[] children;
    
    public TrieNode() {
        completeWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curNode = root;
        for (char curChar : word.toCharArray()) {
            int letterIdx = curChar - 'a';
            // If there isn't already a node here, we create 
            if (curNode.children[letterIdx] == null) {
                curNode.children[letterIdx] = new TrieNode();
            }
            // Continue the traversal.
            curNode = curNode.children[letterIdx];
        }
        // Mark the final node as completing a word.
        curNode.completeWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curNode = root;
        for (char curChar : word.toCharArray()) {
            int letterIdx = curChar - 'a';
            // Traversal failed.
            if (curNode.children[letterIdx] == null) {
                return false;
            }
            // Continue traversal
            curNode = curNode.children[letterIdx];
        }
        // Result
        return curNode.completeWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (char curChar : prefix.toCharArray()) {
            int letterIdx = curChar - 'a';
            // The traversal failed
            if (curNode.children[letterIdx] == null) {
                return false;
            }
            curNode = curNode.children[letterIdx];
        }
        // Otherwise it works
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
