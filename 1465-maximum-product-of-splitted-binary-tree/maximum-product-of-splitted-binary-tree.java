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
    long ans = 0;
    long totalSum;
    static final int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        totalSum = sum(root);
        System.out.println(totalSum);
        maxPro(root);
        return (int)(ans % mod);
    }
    private long maxPro(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long left = maxPro(root.left);
        long right = maxPro(root.right);
        long curr = root.val+left+right;
        long ans1 = (totalSum - curr)*curr;
        ans = Math.max(ans, ans1);
        return curr;
    }
    private long sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long left = sum(root.left);
        long right = sum(root.right);
        return root.val+left+right;
    }
}