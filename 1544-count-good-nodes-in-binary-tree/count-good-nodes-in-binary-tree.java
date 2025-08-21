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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        goodNode(root, root.val);
        return ans;
    }
    public void goodNode(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        if(root.val >= max) {
            ans++;
        }
        int x = Math.max(max, root.val);
        goodNode(root.left, x);
        goodNode(root.right, x);
    }
}