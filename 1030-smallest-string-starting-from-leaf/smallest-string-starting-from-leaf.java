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
    String ans = "";
    StringBuilder str = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        ans = "";
        path(root, "");
        return ans;
    }
    public void path(TreeNode root, String s) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            s += (char)(root.val + 'a');
            str.append(s);
            str.reverse();
            if(ans.equals("")) {
                ans = str.toString();
            }
            else{
                if(ans.compareTo(str.toString()) >= 0) {
                    ans = str.toString();
                }
            }
            str.setLength(0);
            return;
        }
        path(root.left, s + (char)(root.val + 'a'));
        path(root.right, s + (char)(root.val + 'a'));
    }
}