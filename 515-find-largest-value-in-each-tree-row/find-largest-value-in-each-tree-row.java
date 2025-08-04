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
        List<Integer> ll = new ArrayList<>();
        largest(root, 0, ll);
        return ll;
    }
    public void largest(TreeNode root, int cl, List<Integer> ll) {
        if(root == null) {
            return;
        }
        if(cl == ll.size()) {
            ll.add(root.val);
        }
        if(cl < ll.size()) {
            ll.set(cl, Math.max(ll.get(cl), root.val));
        }
        largest(root.left, cl + 1, ll);
        largest(root.right, cl + 1, ll);
    }
}