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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        level_order_zigzag(root, ans);
        return ans;
    }
    public void level_order_zigzag(TreeNode root, List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int turn = 0;
        while(!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> ll = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode rv = qu.remove();//remove first
                ll.add(rv.val);
                if(rv.left != null) {
                    qu.add(rv.left);
                }
                if(rv.right != null) {
                    qu.add(rv.right);
                }
            }
            if(turn == 0) {
                ans.add(ll);
                turn = 1;
            }
            else {
                Collections.reverse(ll);
                ans.add(ll);
                turn = 0;
            }
        }
    }
}