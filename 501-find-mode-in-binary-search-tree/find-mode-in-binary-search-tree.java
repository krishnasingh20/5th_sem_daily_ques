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
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findMode(TreeNode root) {
        traverse(root);
        int c = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == maxFreq) {
                c++;
            }
        }
        int[] ans = new int[c];
        int idx = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == maxFreq) {
                ans[idx++] = key;
            }
        }
        return ans;
    }
    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(root.val));
        traverse(root.left);
        traverse(root.right);
    }
}