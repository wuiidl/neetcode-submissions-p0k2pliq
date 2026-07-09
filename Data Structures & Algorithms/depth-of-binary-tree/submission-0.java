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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    private int bfs(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> currLvl = new LinkedList<>();
        q.offer(root);

        int depth = 0;
        while(!q.isEmpty()) {
            int lvlSize = q.size();
            for(int i = 0; i < lvlSize; i++) {
                TreeNode n = q.poll();
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            depth++; // inc depth
        }
        return depth;
    }
}
