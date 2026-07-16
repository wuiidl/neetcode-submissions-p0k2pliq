/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        oldToNew.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node orig = q.poll();
            for (Node n : orig.neighbors) {
                if (!oldToNew.containsKey(n)) {
                    oldToNew.put(n, new Node(n.val));
                    q.offer(n);
                }
                oldToNew.get(orig).neighbors.add(oldToNew.get(n));
            }
        }
        return oldToNew.get(node);
    }
}