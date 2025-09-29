class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int r, int c, int idx) {
        if(idx == word.length()) {
            return true;
        }
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx) || board[r][c] == '0') {
            return false;
        }
        board[r][c] = '0';
        boolean down = search(board, word, r+1, c, idx+1);
        boolean up = search(board, word, r-1, c, idx+1);
        boolean left = search(board, word, r, c-1, idx+1);
        boolean right = search(board, word, r, c+1, idx+1);
        board[r][c] = word.charAt(idx);
        return (down || up || left || right);
    }
}