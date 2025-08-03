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
    public String smallestFromLeaf(TreeNode root) {
        String ans = "";
        List<String> ll = new ArrayList<>();
        path(root, "", ll);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < ll.size(); i++) {
            str.append(ll.get(i));
            str.reverse();
            if(ans == "") {
                ans = str.toString();
            }
            else {
                if(ans.compareTo(str.toString()) > 0) {
                    ans = str.toString();
                }
            }
            str.setLength(0);
        }
        return ans;
    }
    public void path(TreeNode root, String s, List<String> ll) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            s += (char)(root.val + 'a');
            System.out.println(s);
            ll.add(s);
            return;
        }
        path(root.left, s + (char)(root.val + 'a'), ll);
        path(root.right, s + (char)(root.val + 'a'), ll);
    }
}