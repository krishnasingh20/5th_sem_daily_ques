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
        List<List<Integer>> ans = new ArrayList<>();
        levelorder(root, 0, ans);
        return ans;
    }
    public void levelorder(TreeNode root, int cl, List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        if(cl + 1 <= ans.size()) {
            List<Integer> ll = ans.get(cl);
            ll.add(root.val);
        }
        if(cl + 1 > ans.size()) {
            List<Integer> ll = new ArrayList<>();
            ll.add(root.val);
            ans.add(ll);
        }
        levelorder(root.left, cl + 1, ans);
        levelorder(root.right, cl + 1, ans);
    }
}