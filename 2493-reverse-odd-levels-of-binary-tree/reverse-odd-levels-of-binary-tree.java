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
        List<TreeNode> ll = new ArrayList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.remove();//remove from first
                ll.add(rv);
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            if(level % 2 != 0) {
                reverse(ll);
            }
            level++;
            ll.clear();
        }
        return root;
    }
    public void reverse(List<TreeNode> ll) {
        int i = 0;
        int j = ll.size() - 1;
        while(i < j) {
            TreeNode nn1 = ll.get(i);
            TreeNode nn2 = ll.get(j);
            int temp = nn1.val;
            nn1.val = nn2.val;
            nn2.val = temp;
            i++;
            j--;
        }
    }
}