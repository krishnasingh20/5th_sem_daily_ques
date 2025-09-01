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
    public TreeNode bstFromPreorder(int[] preorder) {
        return create(preorder, 0, preorder.length - 1);
    }
    public TreeNode create(int[] arr, int si, int ei) {
        if(si > ei) {
            return null;
        }
        if(si == ei) {
            return new TreeNode(arr[si]);
        }
        TreeNode node = new TreeNode(arr[si]);
        int idx = -1;
        for(int i = si+1; i <= ei; i++) {
            if(arr[si] < arr[i]) {
                idx = i - 1;
                break;
            }
        }
        if(idx == -1) {
            idx = ei;
        }
        node.left = create(arr, si + 1, idx);
        node.right = create(arr, idx + 1, ei);
        return node;
    }
}