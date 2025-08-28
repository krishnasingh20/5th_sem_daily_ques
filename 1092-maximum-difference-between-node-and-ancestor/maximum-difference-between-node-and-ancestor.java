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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root).ans;
    }
    public Pair maxDiff(TreeNode root) {
        if(root == null) {
            return new Pair();
        }
        Pair lp = maxDiff(root.left);
        Pair rp = maxDiff(root.right);
        Pair sp = new Pair();
        sp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        sp.max = Math.max(root.val, Math.max(lp.max, rp.max));
        if(lp.min != Integer.MAX_VALUE && rp.min != Integer.MAX_VALUE) {
            sp.ans = Math.max(Math.abs(root.val - Math.min(lp.min, rp.min)), Math.abs(root.val-Math.max(lp.max, rp.max)));
        }
        else if(lp.min == Integer.MAX_VALUE && rp.min != Integer.MAX_VALUE) {
            sp.ans = Math.max(Math.abs(root.val - rp.min), Math.abs(root.val - rp.max));
        }
        else if(lp.min != Integer.MAX_VALUE && rp.min == Integer.MAX_VALUE) {
            sp.ans = Math.max(Math.abs(root.val - lp.min), Math.abs(root.val - lp.max));
        }
        sp.ans = Math.max(sp.ans, Math.max(lp.ans, rp.ans));
        return sp;
    }
    class Pair {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}