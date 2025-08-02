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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> ll = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.remove();
                ll.add(rv.val);
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            ans.add(ll);
        }
        return ans;
    }
}