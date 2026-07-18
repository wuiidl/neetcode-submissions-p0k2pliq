class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites) {
            indegree[arr[1]]++;
            adj.get(arr[0]).add(arr[1]);
        }

        int finish = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses;i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int next = q.poll();
            finish++;
            for(int n : adj.get(next)) {
                indegree[n]--;
                if(indegree[n] == 0) q.add(n);
            }
        }


        return finish == numCourses;
    }
}
