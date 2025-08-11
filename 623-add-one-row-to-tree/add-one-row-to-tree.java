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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode();
            newRoot.val = val;
            newRoot.left = root;
            return newRoot; 
        }
        addRow(root, val, depth, 1);
        return root;
    }
    public void addRow(TreeNode root, int val, int depth, int currDepth) {
        if(root == null) {
            return;
        }
        if(currDepth + 1 == depth) {
            TreeNode temp1 = root.left;
            TreeNode temp2 = root.right;
            root.right = new TreeNode(val);
            root.left = new TreeNode(val);
            root.left.left = temp1;
            root.right.right = temp2;
            return; 
        }
        addRow(root.left, val, depth, currDepth + 1);
        addRow(root.right, val, depth, currDepth + 1);
    }
}