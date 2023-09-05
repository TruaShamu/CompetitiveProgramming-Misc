class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    public int dfs(TreeNode cur, long targetSum) {
        int sum = 0;
        if (cur.val == targetSum) {
            sum++;
        }
        if (cur.left != null) {
            sum += dfs(cur.left, targetSum - cur.val);
        }
        if (cur.right != null) {
            sum += dfs(cur.right, targetSum - cur.val);
        }
        return sum;
    }
}
