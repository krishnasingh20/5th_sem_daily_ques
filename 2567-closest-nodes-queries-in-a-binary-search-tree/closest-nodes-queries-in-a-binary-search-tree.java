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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode rv = q.poll();
                set.add(rv.val);
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int query: queries) {
            Integer min = set.floor(query);
            Integer max = set.ceiling(query);
            List<Integer> ll = new ArrayList<>();
            if(min == null) {
                min = -1;
            }
            if(max == null) {
                max = -1;
            }
            ll.add(min);
            ll.add(max);
            ans.add(ll);
        }
        return ans;
    }
}