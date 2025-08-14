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
    long Max = Long.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        long totalsum = totalSum(root);
        maxProduct(root, totalsum);
        return (int)(Max % 1000000007);
    }
    public long maxProduct(TreeNode root, long totalsum) {
        if(root == null) {
            return 0;
        }
        long left = maxProduct(root.left, totalsum);
        long right =maxProduct(root.right, totalsum);
        long currSum = (left + right + root.val);
        Max = Math.max(Max, currSum * (totalsum - currSum));
        return left + right + root.val;
    }
    public long totalSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long left = totalSum(root.left);
        long right = totalSum(root.right);
        return left + right + root.val;
    }
}