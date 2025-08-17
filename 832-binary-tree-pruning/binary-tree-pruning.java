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
    public TreeNode pruneTree(TreeNode root) {
        return Prune(root);
    }
    public TreeNode Prune(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            if(root.val == 0) {
                return null;
            }
            return root;
        }
        TreeNode left = Prune(root.left);
        TreeNode right = Prune(root.right);
        if(left  == null && right == null) {
            root.left = null;
            root.right = null;
            if(root.val == 0) {
                return null;
            }
            return root;
        }
        else if(left == null || right == null) {
            root.left = left;
            root.right = right;
            return root;
        }
        else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}