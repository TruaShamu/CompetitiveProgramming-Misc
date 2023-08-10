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
 // Extremely straightforward: Perform a DFS and keep track of the maximum value on a path.
class Solution {
    int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }
    public void dfs(TreeNode cur, int max) {
        if (max <= cur.val) {
            ans++;
        }
        if (cur.left != null) {
            dfs(cur.left, Math.max(cur.val, max));
        }
        if (cur.right != null) {
            dfs(cur.right, Math.max(cur.val, max));
        }
    }
}
