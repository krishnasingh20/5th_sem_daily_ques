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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            //for 1 and 0 node
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                // for 2 node
                int max = max(root.left);
                root.left = deleteNode(root.left, max);
                root.val = max;
            }
        }
        return root;
    }
    public int max(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(root.left);
        int rm = max(root.right);
        return Math.max(lm, Math.max(rm, root.val));
    }
}