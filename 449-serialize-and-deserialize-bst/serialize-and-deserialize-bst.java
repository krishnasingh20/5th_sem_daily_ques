/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        traverse(root, str);
        return str.toString();
    }
    public void traverse(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append("null,");
            return;
        }
        str.append(root.val).append(',');
        traverse(root.left, str);
        traverse(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        return construct(arr);
    }
    int idx = 0;
    public TreeNode construct(String[] arr) {
        String s = arr[idx++];
        if(s.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(s);
        root.left = construct(arr);
        root.right = construct(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;