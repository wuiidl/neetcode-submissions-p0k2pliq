class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9;i++) {
           if(! validCol(i, board)) return false;
        }

        for(int i =0; i < board.length;i++) {
            if(!validRow(i, board)) return false;
        }

        for(int i = 0; i < 9; i +=3) {
            for(int j = 0; j < 9; j += 3) {
                if(!checkSquare(i, j, board)) return false;
            }
        }
        return true;
    }

    private boolean checkSquare(int row, int col, char[][] board) {
        Set<Character> uniques = new HashSet<>();
        for(int i = row; i < row + 3;i++) {
            for(int j = col; j < col + 3;j++) {
                if(Character.isDigit(board[i][j])) {
                    if(!uniques.add(board[i][j])) return false;
                }
            }
        }
        return true;
    }

    private boolean validRow(int row, char[][] board) {
        Set<Character> uniques = new HashSet<>();
        for(char c : board[row]) {
            if(Character.isDigit(c)) {
                if(!uniques.add(c)) return false;
            }
        }
        return true;
    }

    private boolean validCol(int col, char[][] board) {
        Set<Character> uniques = new HashSet<>();
        for(int i = 0; i < board.length;i++) {
            if(Character.isDigit(board[i][col])) {
                if(!uniques.add(board[i][col])) return false;
            }
        }
        return true;
    }
}
