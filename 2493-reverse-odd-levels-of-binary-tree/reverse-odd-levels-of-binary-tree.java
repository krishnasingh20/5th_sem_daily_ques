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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> ll = new ArrayList<>();
            while(size-- > 0) {
                TreeNode rv = q.poll();
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
                if((level & 1) == 1) {
                    ll.add(rv);
                }
            }
            if((level & 1) == 1) {
                reverse(ll);
            }
            level++;
        }
        return root;
    }
    private void reverse(List<TreeNode> ll) {
        int i = 0;
        int j = ll.size()-1;
        while(i < j) {
            int temp = ll.get(i).val;
            ll.get(i).val = ll.get(j).val;
            ll.get(j).val = temp;
            i++;
            j--;
        }
    }
}