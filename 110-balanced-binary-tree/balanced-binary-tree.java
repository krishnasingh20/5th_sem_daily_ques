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
    //naive approach using nested loop
    public boolean isBalanced(TreeNode root) {
        return isbalance(root);
    }
    public boolean isbalance(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean lb = isbalance(root.left);
        boolean rb = isbalance(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) <= 1 && lb && rb;
    }
    public int height(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
}