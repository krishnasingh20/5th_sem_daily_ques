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
    public int maxLevelSum(TreeNode root) {
        return max_level(root);
    }
    public int max_level(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long max = Integer.MIN_VALUE;
        int level = 1;
        while(!q.isEmpty()) {
            long sum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.remove();//remove first
                sum += rv.val;
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            if(sum > max) {
                ans = level;
                max = sum;
            }
            level++;
        }
        return ans;
    }
}