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
    public int minCameraCover(TreeNode root) {
        int x = minCamera(root);

        if(x == 3) {
            ans++;
        }

        return ans;
    }
    private int minCamera(TreeNode root) {
        if(root == null) {
            return 2;
        }

        int l = minCamera(root.left);
        int r = minCamera(root.right);
        
        if(l == 3 || r == 3) {
            ans++;
            return 1;
        }
        else if(l == 1 || r == 1) {
            return 2;
        }
        else {
            return 3;
        }
    }
}