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
    TreeNode parent1 = null;
    TreeNode parent2 = null;
    int depth1 = 0;
    int depth2 = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y) {
            return false;
        }
        cousins(root, x, y, 0);
        if(parent1.val != parent2.val && depth1 == depth2) {
            return true;
        }
        return false;
    }
    public void cousins(TreeNode root, int x, int y, int depth) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            if(root.left.val == x) {
                depth1 = depth;
                parent1 = root;
            }
            if(root.left.val == y) {
                depth2 = depth;
                parent2 = root;
            }
        }
        if(root.right != null) {
            if(root.right.val == x) {
                depth1 = depth;
                parent1 = root;
            }
            if(root.right.val == y) {
                depth2 = depth;
                parent2 = root;
            }
        }
        cousins(root.left, x, y, depth + 1);
        cousins(root.right, x, y, depth + 1);
    }
}