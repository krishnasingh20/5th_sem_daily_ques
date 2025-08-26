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
    TreeNode ans = null;
    int max = Integer.MIN_VALUE;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lcadeepestLeaves(root, 0);
        return ans;
    }
    public int lcadeepestLeaves(TreeNode root, int curr) {
        if(root == null) {
            return curr;
        }
        int left = lcadeepestLeaves(root.left, curr+1);
        int right = lcadeepestLeaves(root.right, curr+1);
        max = Math.max(Math.max(left, right), max);
        if(left == right && left == max) {
            ans = root;
        }
        return Math.max(left, right);
    }
}