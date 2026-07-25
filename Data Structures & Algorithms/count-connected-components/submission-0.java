class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int component = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(adj, visited, i);
                component++;
            }
        }
        return component;
    }

    private void bfs(List<List<Integer>> adj, boolean[] v, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        v[node] = true;
        while (!q.isEmpty()) {
            int next = q.poll();
            for (int nei : adj.get(next)) {
                if (!v[nei]) {
                    v[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}
