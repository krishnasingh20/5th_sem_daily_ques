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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        levelorder(root, ans);
        return ans;
    }
    public void levelorder(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ll = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.remove();//remove first
                ll.add(rv.val);
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            Collections.sort(ll);
            ans.add(ll.get(size - 1));
        }
    }
}