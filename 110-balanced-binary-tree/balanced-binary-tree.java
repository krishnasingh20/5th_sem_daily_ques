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
    public boolean isBalanced(TreeNode root) {
        return Balance(root).isBal;
    }
    private Pair Balance(TreeNode root) {
        if(root == null) {
            Pair p = new Pair();
            p.depth = 0;
            p.isBal = true;
            return p;
        }
        Pair lp = Balance(root.left);
        Pair rp = Balance(root.right);
        Pair sp = new Pair();
        sp.depth = Math.max(lp.depth, rp.depth)+1;
        sp.isBal = (Math.abs(lp.depth-rp.depth) <= 1 && lp.isBal && rp.isBal);
        return sp;
    }
    class Pair {
        int depth;
        boolean isBal;
    }
}