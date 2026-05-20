class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    // increment result
                    res++;
                    // mark connected cells
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        // we stop search if we "step" out of the grid or if we hit a cell that's not 1
        if(i >= n || j >= m || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
