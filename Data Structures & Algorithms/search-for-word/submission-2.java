class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        char first = word.charAt(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == first) {
                    if(dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int ptr) {

        int m = board.length;
        int n = board[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || 
        ptr >= word.length() || visited[i][j] || 
        board[i][j] != word.charAt(ptr)) {
            return false;
        }

        if(ptr == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        boolean res = dfs(board, word, i + 1, j, ptr + 1) || 
        dfs(board, word, i - 1, j, ptr + 1) || 
        dfs(board, word, i, j + 1, ptr + 1) ||
        dfs(board, word, i, j - 1, ptr + 1);
        visited[i][j] = false;
        return res;
    }
}
