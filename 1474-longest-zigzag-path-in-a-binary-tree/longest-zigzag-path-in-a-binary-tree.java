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
    public int longestZigZag(TreeNode root) {
        dp = new HashMap<>();
        return zigzag(root, 0);
    }
    HashMap<TreeNode, Integer[]> dp;
    private int zigzag(TreeNode root, int dir) {
        if(root == null) {
            return -1;
        }
        if(!dp.containsKey(root)) {
            dp.put(root, new Integer[3]);
        }
        if(dp.get(root)[dir] != null) {
            return dp.get(root)[dir];
        }
        int ans = Integer.MIN_VALUE;
        if(dir == 0) {
            int l = 1 + zigzag(root.left, 1);
            int r = 1 + zigzag(root.right, 2);
            ans = Math.max(ans, Math.max(l, r));

            int skipL = zigzag(root.left, 0);
            int skipR = zigzag(root.right, 0);
            ans = Math.max(ans, Math.max(skipL, skipR));
        }
        else if(dir == 1) {
            int r = 1 + zigzag(root.right, 2);
            ans = Math.max(ans, r);
        }
        else {
            int l = 1 + zigzag(root.left, 1);
            ans = Math.max(ans, l);
        }
        dp.get(root)[dir] = ans;
        return ans;
    }
}