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
    int count = 0;
    int[] freq = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        pseudoPath(root);
        return count;
    }
    public void pseudoPath(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            freq[root.val]++;
            if(isPalindrome()) {
                count++;
            }
            freq[root.val]--;
            return;
        }
        freq[root.val]++;
        pseudoPath(root.left);
        pseudoPath(root.right);
        freq[root.val]--;
    }
    public boolean isPalindrome() {
        int odd = 0;
        for(int i = 0; i < 10; i++) {
            if((freq[i] & 1) == 1){
                odd++;
            }
        }
        return odd <= 1;
    }
}