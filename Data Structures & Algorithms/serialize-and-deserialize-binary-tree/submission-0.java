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

public class Codec {

    // in order traversal. append to StringBuilder
    private List<String> res = new LinkedList<>();
    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ser(root, res);
        return String.join(",", res);
    }

    private void ser(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("null");
            return;
        } 
        res.add(String.valueOf(root.val));
        ser(root.left, res);
        ser(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        this.index = 0;
        return deser(values);
    }

    private TreeNode deser(String[] values) {
        if(values[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        index++;
        node.left = deser(values);
        node.right = deser(values);
        return node;
    }
}
