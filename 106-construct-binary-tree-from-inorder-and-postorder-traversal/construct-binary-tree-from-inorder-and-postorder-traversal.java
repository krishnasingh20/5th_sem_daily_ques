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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
        if(ilo > ihi || plo > phi) {
            return null;
        }
        TreeNode node = new TreeNode(post[phi]);
        int idx = Search(in, ilo, ihi, post[phi]);
        int c = ihi - idx;
        node.right = build(post, phi - c, phi - 1, in, idx + 1, ihi);
        node.left = build(post, plo, phi - c - 1, in, ilo, idx - 1);
        return node;
    }
    public int Search(int[] in, int si, int ei, int item) {
        for(int i = si; i <= ei; i++) {
            if(in[i] == item) {
                return i;
            }
        }
        return -1;
    }
}