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
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(dp.get(root) != null) {
            return dp.get(root);
        }
        int rob = root.val;
        if(root.left != null) {
            rob += dfs(root.left.left);
            rob += dfs(root.left.right);
        }
        if(root.right != null) {
            rob += dfs(root.right.left);
            rob += dfs(root.right.right);
        }
        int notRob = 0;
        notRob += dfs(root.left);
        notRob += dfs(root.right);
        dp.put(root, Math.max(rob, notRob));
        return Math.max(rob, notRob);
    }
}