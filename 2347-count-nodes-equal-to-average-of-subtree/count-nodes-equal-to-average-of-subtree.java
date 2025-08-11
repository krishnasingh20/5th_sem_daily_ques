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
    public int averageOfSubtree(TreeNode root) {
        return avgOfSubtree(root).totalNode;
    }
    public AvgNode avgOfSubtree(TreeNode root) {
        if(root == null) {
            return new AvgNode();
        }
        AvgNode l = avgOfSubtree(root.left);
        AvgNode r = avgOfSubtree(root.right);
        AvgNode self = new AvgNode();
        self.noOfNode = l.noOfNode + r.noOfNode + 1;
        self.sumOfSubTree = l.sumOfSubTree + r.sumOfSubTree + root.val;
        self.totalNode = l.totalNode + r.totalNode;
        double avg = (1.0*self.sumOfSubTree) / self.noOfNode;
        if((int)Math.floor(avg) == root.val) {
            self.totalNode = self.totalNode + 1;
        }
        return self;
    }
    public class AvgNode {
        int noOfNode = 0;
        int sumOfSubTree = 0;
        int totalNode = 0;
    }
}