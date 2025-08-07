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
    public int maxSumBST(TreeNode root) {
        return max_sum(root).ans;
    }
    public BstPair max_sum(TreeNode root) {
        if(root == null) {
            return new BstPair();
        }
        BstPair lbp = max_sum(root.left);
        BstPair rbp = max_sum(root.right);
        BstPair sbp = new BstPair();
        sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
        sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
        sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val;
        sbp.sum = lbp.sum + rbp.sum + root.val;
        if(sbp.isbst) {
            sbp.ans = Math.max(lbp.ans, Math.max(rbp.ans, sbp.sum));
        }
        else {
            sbp.ans = Math.max(lbp.ans, rbp.ans);
        }
        return sbp;
    }
    class BstPair {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isbst = true;
        int ans = 0;
        int sum = 0;
    }
}