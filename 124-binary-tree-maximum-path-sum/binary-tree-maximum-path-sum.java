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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return -10000;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        ans = Math.max(ans, root.val);
        ans = Math.max(ans, root.val+l);
        ans = Math.max(ans, root.val+r);
        ans = Math.max(ans, root.val+r+l);

        int curr = root.val;
        curr = Math.max(curr, root.val+l);
        curr = Math.max(curr, root.val+r);

        return curr;
    }
}