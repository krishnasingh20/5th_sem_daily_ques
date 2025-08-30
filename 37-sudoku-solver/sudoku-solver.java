class Solution {
    public void solveSudoku(char[][] board) {
        Sudoku(board, 0, 0);
    }
    public boolean Sudoku(char[][] board, int col, int row) {
        if(col == 9) {
            row++;
            col = 0;
        }
        if(row == 9) {
            return true;
        }
        if(board[row][col] != '.') {
            return Sudoku(board, col + 1, row);
        }
        for(int val = 1; val <= 9; val++) {
            if(!isPresent(board, row, col, (char)(val+'0'))) {
                board[row][col] = (char)(val+'0');
                if(Sudoku(board, col + 1, row)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }  
    public boolean isPresent(char[][] board, int row, int col, char ch) {
        //in rowth row
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == ch) {
                return true;
            }
        }

        //in colth column
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == ch) {
                return true;
            }
        }

        // in submatrix of size 3x3
        int r = row - (row % 3);
        int c = col - (col % 3);
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }
}