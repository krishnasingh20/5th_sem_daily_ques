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
    List<Double> ans = new ArrayList<>();
    List<Integer> ll = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        average(root, 0);
        for(int i = 0; i < ll.size(); i++) {
            double sum = ans.get(i);
            int n = ll.get(i);
            ans.set(i, sum / n);
        }
        return ans;
    }
    public void average(TreeNode root, int cl) {
        if(root == null) {
            return;
        }
        if(ll.size() < cl + 1) {
            ll.add(1);
            ans.add(root.val*1.0);
        }
        else {
            ll.set(cl, ll.get(cl) + 1);
            double val = ans.get(cl);
            ans.set(cl, val + root.val);
        }
        average(root.left, cl + 1);
        average(root.right, cl + 1);
    }
}