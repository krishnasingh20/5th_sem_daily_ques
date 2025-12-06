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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    public TreeNode dfs(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            if(root.val >= low && root.val <= high) {
                return root;
            }
            return null;
        }
        TreeNode left = dfs(root.left, low, high);
        TreeNode right = dfs(root.right, low, high);
        if(root.val < low || root.val > high) {
            root.left = null;
            root.right = null;
            if(root.val < low) {
                return right;
            }
            else {
                return left;
            }
        }
        else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}