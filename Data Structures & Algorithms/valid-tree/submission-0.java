class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length > n) return false;

        List<List<Integer>> adj = new LinkedList<>();

        for(int i = 0; i < n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        //nodeToParent
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, -1});
        Set<Integer> visit = new HashSet<>();
        visit.add(0);

        while(!q.isEmpty()) {
            int[] next = q.poll();
            int node = next[0];
            int parent = next[1];

            for(int nei : adj.get(node)) {
                if(nei == parent) continue;
                if(!visit.add(nei)) return false;
                q.offer(new int[]{nei, node});
            }

        }
        return visit.size() == n;
    }
}
