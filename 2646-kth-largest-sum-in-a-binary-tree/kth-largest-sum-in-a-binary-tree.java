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
    public long kthLargestLevelSum(TreeNode root, int k) {
        return largestsum_levelwise(root, k);
    }
    public long largestsum_levelwise(TreeNode root, int k) {
        List<Long> ll = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()) {
            int size = qu.size();
            long levelsum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode rv = qu.remove();
                levelsum += rv.val;
                if(rv.left != null) {
                    qu.add(rv.left);
                }
                if(rv.right != null) {
                    qu.add(rv.right);
                }
            }
            ll.add(levelsum);
        }
        if(ll.size() < k) {
            return -1;
        }
        Collections.sort(ll);
        return ll.get(ll.size() - k);
    }
}