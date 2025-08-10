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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ll = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            double sum = 0.0;
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.remove();//remove from first
                sum += rv.val;
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            ll.add(sum / size);
        }
        return ll;
    }
}