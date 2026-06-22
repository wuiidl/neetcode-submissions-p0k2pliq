class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < 9; i++) {
            if (!isValid(board[i]))
                return false;
        }
        // check cols
        for (int i = 0; i < 9; i++) {
            if (!isValid(getCol(board, i)))
                return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(flattenGrid(board, i, j)))
                    return false;
            }
        }
        return true;
    }

    private boolean isValid(char[] rowOrColumn) {
        Set<Character> v = new HashSet<>();
        for (char c : rowOrColumn) {
            if (c == '.')
                continue; // skip empty cells
            // check duplicates
            if (!v.add(c))
                return false;
        }
        return true;
    }

    private char[] flattenGrid(char[][] grid, int row, int col) {
        char[] flattened = new char[9];
        int ptr = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                flattened[ptr++] = grid[i][j];
            }
        }
        return flattened;
    }

    private char[] getCol(char[][] grid, int idx) {
        char[] col = new char[9];
        int i = 0;
        for (char[] row : grid) {
            col[i++] = row[idx];
        }
        return col;
    }
}
