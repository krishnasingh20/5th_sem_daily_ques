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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        // iterative approach
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode rv = st.pop();
            if(rv.left == null && rv.right == null) {
                ans.add(rv.val);
            }
            else if(rv.left == null) {
                ans.add(rv.val);
                st.push(rv.right);
            }
            else {
                if(rv.right != null) {
                    st.push(rv.right);
                    rv.right = null;
                }
                st.push(rv);
                st.push(rv.left);
                rv.left = null;
            }
        }
        return ans;
    }
}