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
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key: map.keySet()) {
            TreeMap<Integer, List<Integer>> map1 = map.get(key);
            List<Integer> ll = map1.pollFirstEntry().getValue();
            Collections.sort(ll);
            for(int key1: map1.keySet()) {
                List<Integer> l1 = map1.get(key1);
                Collections.sort(l1);
                ll.addAll(l1);
            }
            ans.add(ll);
        }
        return ans;
    }
    public void dfs(TreeNode root, int r, int c) {
        if(root == null) {
            return;
        }
        dfs(root.left, r+1, c-1);//left child
        dfs(root.right, r+1, c+1);//right child
        if(map.containsKey(c)) {
            if(map.get(c).containsKey(r)) {
                map.get(c).get(r).add(root.val);
            }
            else {
                List<Integer> ll = new ArrayList<>();
                ll.add(root.val);
                map.get(c).put(r, ll);
            }
        }
        else {
            map.put(c, new TreeMap<>());
            List<Integer> ll = new ArrayList<>();
            ll.add(root.val);
            map.get(c).put(r, ll);
        }
    }
}