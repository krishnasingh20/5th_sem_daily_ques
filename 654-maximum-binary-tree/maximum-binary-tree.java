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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return Max_BinaryTree(nums, 0, nums.length - 1);
    }
    public TreeNode Max_BinaryTree(int[] nums, int si, int ei) {
        if(si > ei) {
            return null;
        }
        int max = -1;
        int idx = -1;
        for(int i = si; i <= ei; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = nums[idx];
        root.left = Max_BinaryTree(nums, si, idx - 1);
        root.right = Max_BinaryTree(nums, idx + 1, ei);
        return root;
    }
}