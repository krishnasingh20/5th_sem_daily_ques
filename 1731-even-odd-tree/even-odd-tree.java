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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(level == 0) {
                int prev = Integer.MIN_VALUE;
                for(int i = 0; i < size; i++) {
                    TreeNode rv = q.poll();
                    if((rv.val & 1) == 0 || prev >= rv.val) {
                        return false;
                    }
                    if(rv.left != null) {
                        q.add(rv.left);
                    }
                    if(rv.right != null) {
                        q.add(rv.right);
                    }
                    prev = rv.val;
                }
                level = 1;
            }
            else {
                int prev = Integer.MAX_VALUE;
                for(int i = 0; i < size; i++) {
                    TreeNode rv = q.poll();
                    if((rv.val & 1) == 1 || prev <= rv.val) {
                        return false;
                    }
                    if(rv.left != null) {
                        q.add(rv.left);
                    }
                    if(rv.right != null) {
                        q.add(rv.right);
                    }
                    prev = rv.val;
                }
                level = 0;
            }
        }
        return true;
    }
}