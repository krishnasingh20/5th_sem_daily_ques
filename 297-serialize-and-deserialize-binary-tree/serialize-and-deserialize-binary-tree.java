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
    StringBuilder str = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traversal(root);
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
    public void traversal(TreeNode root) {
        if(root == null) {
            str.append("null,");
            return;
        }
        str.append(root.val).append(',');
        traversal(root.left);
        traversal(root.right);
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
        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(s);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));