class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(isPresent(board, board[i][j], i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isPresent(char[][] board, char ch, int row, int col) {
        if(ch == '.') {
            return false;
        }
        //in ith row
        for(int j = col + 1; j < board[0].length; j++) {
            if(board[row][j] == ch) {
                return true;
            }
        }

        //in jth coloumn
        for(int i = row + 1; i < board.length; i++) {
            if(board[i][col] == ch) {
                return true;
            }
        }

        // in submatrix 
        int r = row - (row % 3);
        int c = col - (col % 3);
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(i != row && j != col && board[i][j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }
}