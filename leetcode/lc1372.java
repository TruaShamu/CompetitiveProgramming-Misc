/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLen;
        
        
    }

    public void dfs(TreeNode oNode, boolean left, int len) {
        maxLen = Math.max(maxLen, len);
        if (oNode.left != null) {    
            if (left) {
                dfs(oNode.left, true, 1);
            } else {
                dfs(oNode.left, true, len+1);
            }
            
        }
        if (oNode.right != null) {
            if (left) {
                dfs(oNode.right, false, len+1);
            } else {
                dfs(oNode.right, false, 1);
            }
        }
    }
}
