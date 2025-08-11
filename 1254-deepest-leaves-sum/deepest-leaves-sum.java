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
    int maxdepth = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        depth(root, 0);
        return sum;
    }
    public void depth(TreeNode root, int cl) {
        if(root == null) {
            return;
        }
        if(maxdepth < cl) {
            sum = root.val;
            maxdepth = cl;
        }
        else if(maxdepth == cl) {
            sum += root.val;
        }
        depth(root.left, cl + 1);
        depth(root.right, cl + 1);
    }
}