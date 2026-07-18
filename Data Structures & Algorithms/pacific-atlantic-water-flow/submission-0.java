class Solution {
    private static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] atlantic = new boolean[ROWS][COLS];
        boolean[][] pacific = new boolean[ROWS][COLS];

        Queue<int[]> aq = new LinkedList<>();
        Queue<int[]> pq = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            pq.offer(new int[] {r, 0});
            aq.offer(new int[] {r, COLS - 1});
        }
        for (int c = 0; c < COLS; c++) {
            pq.offer(new int[] {0, c});
            aq.offer(new int[] {ROWS - 1, c});
        }

        bfs(heights, aq, atlantic);
        bfs(heights, pq, pacific);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (atlantic[r][c] && pacific[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] ocean) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            ocean[r][c] = true;

            // add the cells we can reach
            for(int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                // only add valid cells
                if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && !ocean[nr][nc] && 
                    heights[nr][nc] >= heights[r][c]
                ) {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
