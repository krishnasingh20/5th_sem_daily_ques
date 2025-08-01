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
    public int minDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ld = minDepth(root.left);
        int rd = height(root.right);
        if(root.left == null && root.right == null) {
            return 1;
        }
        else if(root.left == null) {
            return rd + 1;
        }
        else if(root.right == null){
            return ld + 1;
        }
        else {
            return Math.min(ld, rd) + 1;
        }
    }
}