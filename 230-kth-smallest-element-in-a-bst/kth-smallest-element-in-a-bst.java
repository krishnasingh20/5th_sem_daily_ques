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
    static int k1 = 0;
    public int kthSmallest(TreeNode root, int k) {
        k1 = k;
        traversal(root);
        return ans;
    }
    public void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        if(k1 <= 0) {
            return;
        }
        traversal(root.left);
        if(k1 > 0) {
            ans = root.val;
            k1--;
        }
        traversal(root.right);
    }
}