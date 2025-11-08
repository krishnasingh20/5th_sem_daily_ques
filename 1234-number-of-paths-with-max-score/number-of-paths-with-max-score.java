class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int[][] dp1 = new int[board.size()][board.get(0).length()];
        for(int[] d: dp1) {
            Arrays.fill(d, -1);
        }
        int max = maxPath(board, 0, 0, dp1);
        if(max < 0) {
            return new int[]{0, 0};
        }
        int[][][] dp2 = new int[board.size()][board.get(0).length()][max+1];
        for(int[][] d: dp2) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        int count = countPath(board, 0, 0, max, dp2);
        return new int[]{max, count};
    }
    public int maxPath(List<String> board, int r, int c, int[][] dp) {
        if(r == board.size() - 1 && c == board.get(0).length() - 1) {
            return 0;
        }
        if(r >= board.size() || c >= board.get(0).length() || board.get(r).charAt(c) == 'X') {
            return Integer.MIN_VALUE;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int ans = 0;
        if(r != 0 || c != 0) {
            ans = (board.get(r).charAt(c)-'0');
        }
        int down = maxPath(board, r+1, c, dp);
        int right = maxPath(board, r, c+1, dp);
        int diagonal = maxPath(board, r+1, c+1, dp);
        return dp[r][c] = ans + (Math.max(down, Math.max(right, diagonal)));
    }
    public int countPath(List<String> board, int r, int c, int max, int[][][] dp) {
        if(r == board.size() - 1 && c == board.get(0).length() - 1) {
            return max == 0?1:0;
        }
        if(r >= board.size() || c >= board.get(0).length() || board.get(r).charAt(c) == 'X') {
            return 0;
        }
        if(dp[r][c][max] != -1) {
            return dp[r][c][max];
        }
        int val = 0;
        if(r != 0 || c != 0) {
            val = board.get(r).charAt(c)-'0';
        }
        int down = countPath(board, r+1, c, max-val, dp);
        int right = countPath(board, r, c+1, max-val, dp);
        int diagonal = countPath(board, r+1, c+1, max-val, dp);
        return dp[r][c][max] = (down + right + diagonal) % 1000000007;
    }
}