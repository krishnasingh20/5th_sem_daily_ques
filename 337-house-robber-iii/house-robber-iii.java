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
    public int rob(TreeNode root) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        return dfs(1, root, dp);
    }
    public int dfs(int i, TreeNode root, HashMap<Integer, Integer> dp) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        int rob = root.val;
        if(root.left != null) {
            rob += dfs((i*2)*2, root.left.left, dp);
            rob += dfs((i*2)*2 + 1, root.left.right, dp);
        }
        if(root.right != null) {
            rob += dfs(((i*2)+1)*2, root.right.left, dp);
            rob += dfs(((i*2)+1)*2 + 1, root.right.right, dp);
        }
        int notRob = 0;
        notRob += dfs(i*2, root.left, dp);
        notRob += dfs((i*2)+1, root.right, dp);
        dp.put(i, Math.max(rob, notRob));
        return Math.max(rob, notRob);
    }
}