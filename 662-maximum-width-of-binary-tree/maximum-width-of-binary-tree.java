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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair();
        p.node = root;
        p.idx = 0;
        q.add(p);
        int ans = 0;
        while(!q.isEmpty()) {
            Pair start = q.peek();
            Pair end = start;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair rv = q.poll();
                end = rv;
                if(rv.node.left != null) {
                    Pair nn = new Pair();
                    nn.node = rv.node.left;
                    nn.idx = 2 * rv.idx + 1;//formula for finding index of ith parent left child
                    q.add(nn);
                }
                if(rv.node.right != null) {
                    Pair nn = new Pair();
                    nn.node = rv.node.right;
                    nn.idx = 2 * rv.idx + 2;//formula for finding index of ith parent right child 
                    q.add(nn);
                }
            }
            ans = Math.max(ans, (end.idx - start.idx + 1));
        }
        return ans;
    }
    class Pair {
        int idx;
        TreeNode node;
    }
}