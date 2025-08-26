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
    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandParent(-1, -1, root);
        return ans;
    }
    public void sumEvenGrandParent(int grandParent, int parent, TreeNode child) {
        if(child == null) {
            return;
        }
        if(grandParent % 2 == 0) {
            ans += child.val;
        }
        sumEvenGrandParent(parent, child.val, child.left);
        sumEvenGrandParent(parent, child.val, child.right);
    }
}