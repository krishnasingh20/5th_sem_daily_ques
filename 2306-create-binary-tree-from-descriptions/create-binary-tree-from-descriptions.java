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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> parent = new HashSet<>();

        for(int[] d: descriptions) {
            int p = d[0];
            int c = d[1];
            TreeNode p1;
            TreeNode c1;
            
            if(!map.containsKey(p)) {
                p1 = new TreeNode(p);
                map.put(p, p1);
                parent.add(p);
            }
            else {
                p1 = map.get(p);
            }

            if(!map.containsKey(c)) {
                c1 = new TreeNode(c);
                map.put(c, c1);
            }
            else {
                c1 = map.get(c);
                if(parent.contains(c)) {
                    parent.remove(c);
                }
            }

            if(d[2] == 1) {
                p1.left = c1;
            }
            else {
                p1.right = c1;
            }
        }

        return map.get(parent.iterator().next());
    }
}