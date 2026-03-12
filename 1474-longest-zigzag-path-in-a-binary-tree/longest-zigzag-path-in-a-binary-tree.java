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
    HashMap<TreeNode, Integer> map = new HashMap<>();
    int id = 1;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        dp = new Integer[id+1][3];
        return zigzag(root, 0);
    }
    Integer[][] dp;
    private int zigzag(TreeNode root, int dir) {
        if(root == null) {
            return -1;
        }
        int i = map.get(root);
        if(dp[i][dir] != null) {
            return dp[i][dir];
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
        return dp[i][dir] = ans;
    }
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        map.put(root, id++);
        dfs(root.left);
        dfs(root.right);
    }
}