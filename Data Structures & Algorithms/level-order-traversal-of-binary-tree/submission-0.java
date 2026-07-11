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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if(root == null) return levels;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()) {
            int lvl = q.size();
            List<Integer> nodes = new LinkedList<>();
            for(int i = 0; i < lvl;i++) {
                TreeNode next = q.poll();
                nodes.add(next.val);
                if(next.left != null) q.offer(next.left);
                if(next.right != null) q.offer(next.right);
            }
            levels.add(nodes);
        }
        return levels;
    }
}
