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
    int max = Integer.MIN_VALUE;
    TreeNode ans = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        subtree(root, 0);
        return ans;
    }
    public int subtree(TreeNode root, int curr) {
        if(root == null) {
            return curr;
        }
        int left = subtree(root.left, curr + 1);
        int right = subtree(root.right, curr + 1);
        max = Math.max(Math.max(left, right), max);
        if(left == right && left == max) {
            ans = root;
        }
        return Math.max(left, right);
    }
}