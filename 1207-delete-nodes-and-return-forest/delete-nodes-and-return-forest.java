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
    HashSet<Integer> set;
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int d: to_delete) {
            set.add(d);
        }
        TreeNode node = dfs(root);
        if(node != null) {
            ans.add(node);
        }
        return ans;
    }
    public TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if(set.contains(root.val)) {
            if(left != null) {
                ans.add(left);
            }
            if(right != null) {
                ans.add(right);
            }
            return null;
        }
        else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}