class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length;
        int COL = heights[0].length;
        boolean[][] po = new boolean[ROW][COL];
        boolean[][] ao = new boolean[ROW][COL];
        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();

        // seed left, right cols
        for (int i = 0; i < ROW; i++) {
            pac.offer(new int[] {i, 0});
            atl.offer(new int[] {i, COL - 1});
        }

        // seed top, bottom row
        for (int i = 0; i < COL; i++) {
            pac.offer(new int[] {0, i});
            atl.offer(new int[] {ROW - 1, i});
        }

        bfs(po, pac, heights);
        bfs(ao, atl, heights);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (po[i][j] && ao[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(boolean[][] ocean, Queue<int[]> cells, int[][] heights) {

        int ROW = heights.length;
        int COL = heights[0].length;

        while (!cells.isEmpty()) {
            int[] n = cells.poll();
            int r = n[0];
            int c = n[1];

            ocean[r][c] = true;

            for(int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < ROW && nc < COL && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    cells.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
