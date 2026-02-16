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
    public List<Integer> preorderTraversal(TreeNode root) {
        //iterative approach
        if(root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode rv = st.pop();
            ans.add(rv.val);
            if(rv.right != null) {
                st.push(rv.right);
            }
            if(rv.left != null) {
                st.push(rv.left);
            }
        }
        return ans;
    }
}