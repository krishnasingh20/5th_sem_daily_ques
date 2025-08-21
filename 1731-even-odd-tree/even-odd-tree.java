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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ll = new ArrayList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rv = q.poll();
                ll.add(rv.val);
                if(rv.left != null) {
                    q.add(rv.left);
                }
                if(rv.right != null) {
                    q.add(rv.right);
                }
            }
            if(level == 0) {
                for(int i = 0; i < size; i++) {
                    if(i+1 < size && ll.get(i) >= ll.get(i+1)) {
                        return false;
                    }
                    if(ll.get(i) % 2 == 0) {
                        return false;
                    }
                }
                level = 1;
            }
            else {
                for(int i = 0; i < size; i++) {
                    if(i+1 < size && ll.get(i) <= ll.get(i+1)) {
                        return false;
                    }
                    if(ll.get(i) % 2 != 0) {
                        return false;
                    }
                }
                level = 0;
            }
            ll.clear();
        }
        return true;
    }
}