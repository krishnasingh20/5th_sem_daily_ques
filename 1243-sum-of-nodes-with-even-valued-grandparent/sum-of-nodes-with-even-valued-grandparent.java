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
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandParent(-1, -1, root);
    }
    public int sumEvenGrandParent(int grandParent, int parent, TreeNode child) {
        if(child == null) {
            return 0;
        }
        int left = sumEvenGrandParent(parent, child.val, child.left);
        int right = sumEvenGrandParent(parent, child.val, child.right);
        if((grandParent & 1) == 0) {
            return left + right + child.val;
        }
        return left + right;
    }
}