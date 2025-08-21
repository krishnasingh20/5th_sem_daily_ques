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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return remove(root, target);
    }
    public TreeNode remove(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                return null;
            }
            return root;
        }
        TreeNode left = remove(root.left, target);
        TreeNode right = remove(root.right, target);
        root.left = left;
        root.right = right;
        if(left == null && right == null && root.val == target) {
            return null;
        }
        return root;
    }
}