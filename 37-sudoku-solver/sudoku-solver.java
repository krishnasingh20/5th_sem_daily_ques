class Solution {
    public void solveSudoku(char[][] board) {
        Sudoku(board, 0, 0);
    }
    public boolean Sudoku(char[][] board, int row, int col) {
        if(col == 9) {
            col = 0;
            row++;
        }
        if(row == 9) {
            return true;
        }
        if(board[row][col] != '.') {
            return Sudoku(board, row, col+1);
        }
        for(int val = 1; val <= 9; val++) {
            if(isPresent(board, row, col, (char)(val+'0'))) {
                board[row][col] = (char)(val+'0');
                if(Sudoku(board, row, col+1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public boolean isPresent(char[][] board, int row, int col, char val) {
        // row wise searching
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == val) {
                return false;
            }
        }

        // coloumn wise searching 
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == val) {
                return false;
            }
        }

        // in submatrix of size 3x3
        int r = row - (row % 3);
        int c = col - (col % 3);
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}