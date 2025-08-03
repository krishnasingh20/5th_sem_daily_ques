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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        paths(root, "", ans);
        return ans;
    }
    public void paths(TreeNode root, String path, List<String> ll) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            path += root.val;
            ll.add(path);
            return;
        }
        paths(root.left, path + root.val + "->", ll);
        paths(root.right, path + root.val + "->", ll);
    }
}