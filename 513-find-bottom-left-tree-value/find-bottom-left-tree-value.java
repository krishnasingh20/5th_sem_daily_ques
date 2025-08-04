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
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        return levelorder(root);
    }
    public int levelorder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int ans = 0;
        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i = 0; i < size; i++) {
                TreeNode rv = qu.remove();//remove first
                if(i == 0) {
                    ans = rv.val;
                }
                if(rv.left != null) {
                    qu.add(rv.left);
                }
                if(rv.right != null) {
                    qu.add(rv.right);
                }
            }
        }
        return ans;
    }
}