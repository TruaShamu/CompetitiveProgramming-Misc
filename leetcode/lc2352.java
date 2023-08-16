class TrieNode {
    // The children of the node.
    HashMap<Integer, TrieNode> children;
    int count;
    
    public TrieNode() {
        this.count = 0;
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode node;
    
    public Trie() {
        node = new TrieNode();
    }
    
    public void insert(int[] arr) {
        TrieNode curNode = node;
        for (int i : arr) {
            // If there isn't already a node here, we create 
            if (!curNode.children.containsKey(i)) {
                curNode.children.put(i, new TrieNode());
            }
            // Continue the traversal.
            curNode = curNode.children.get(i);
        }
        curNode.count++;
    }
    
    public int search(int[] arr) {
        TrieNode curNode = node;
        for (int i : arr) {
            if (!curNode.children.containsKey(i)) {
                return 0;
            }
            // Continue traversal
            curNode = curNode.children.get(i);
        }
        // Result
        return curNode.count;
    }

}


class Solution {
    public int equalPairs(int[][] grid) {
        Trie trie = new Trie();
        int ret = 0;
        int N = grid.length;
        for (int[] row : grid) {
            trie.insert(row);
        }
        for (int i=0; i< N; i++) {
            int[] col = new int[N];
            for (int j=0; j< N; j++) {
                col[j] = grid[j][i];
            }
            ret += trie.search(col);    
        }
        return ret;
        
    }
}
