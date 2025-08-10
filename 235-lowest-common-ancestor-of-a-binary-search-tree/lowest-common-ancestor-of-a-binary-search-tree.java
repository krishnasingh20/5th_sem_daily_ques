/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) {
            return root;
        }
        if((root.left == p && root.right == q) || (root.left == q && root.right == p)) {
            return root;
        }
        if((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}