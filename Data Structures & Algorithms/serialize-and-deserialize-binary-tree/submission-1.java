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

    private static final String NP = "null";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        ser(root, res);
        return String.join(",", res);
    }

    private void ser(TreeNode root, List<String> res) {
        if(root == null) {
            res.add(NP);
        } else {
            res.add(root.val + "");
            ser(root.left, res);
            ser(root.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] idx = new int[1];
        return deser(vals, idx);
    }

    private TreeNode deser(String[] vals, int[] idx) {
        String rootVal = vals[idx[0]++];
        if(rootVal.equals(NP)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deser(vals, idx);
        root.right = deser(vals, idx);
        return root;
    }
}
