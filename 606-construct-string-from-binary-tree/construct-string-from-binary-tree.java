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
    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode root) {
        tree_to_str(root);
        return str.toString();
    }
    public void tree_to_str(TreeNode root) {
        if(root == null) {
            return;
        }
        str.append(root.val);
        if(root.left == null && root.right == null) {
            return;
        }
        if(root.left == null) {
            str.append("()");
        }
        if(root.left != null) {
            str.append('(');
            tree_to_str(root.left);
            str.append(')');
        }
        if(root.right != null) {
            str.append('(');
            tree_to_str(root.right);
            str.append(')');
        }
    }
}