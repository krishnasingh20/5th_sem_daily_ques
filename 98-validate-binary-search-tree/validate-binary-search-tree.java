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
    public boolean isValidBST(TreeNode root) {
        return isValid(root).isBST;
    }
    private BST_Pair isValid(TreeNode root) {
        if(root == null) {
            BST_Pair p = new BST_Pair();
            p.min = Long.MAX_VALUE;
            p.max = Long.MIN_VALUE;
            p.isBST = true;
            return p;
        }
        BST_Pair lp = isValid(root.left);
        BST_Pair rp = isValid(root.right);
        BST_Pair sp = new BST_Pair();
        sp.isBST = (lp.isBST && rp.isBST && lp.max < root.val && rp.min > root.val);
        sp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        sp.max = Math.max(root.val, Math.max(lp.max, rp.max));
        return sp;
    }
    class BST_Pair {
        long min;
        long max;
        boolean isBST;
    }
}