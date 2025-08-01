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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).dia;
    }
    public Diapair diameter(TreeNode root) {
        if(root == null) {
            return new Diapair();
        }
        Diapair ldp = diameter(root.left);
        Diapair rdp = diameter(root.right);
        Diapair sdp = new Diapair();
        sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
        int sd = ldp.ht + rdp.ht + 2;
        sdp.dia = Math.max(sd, Math.max(ldp.dia, rdp.dia));
        return sdp;
    }
    class Diapair {
        int dia = 0;
        int ht = -1;
    }
}