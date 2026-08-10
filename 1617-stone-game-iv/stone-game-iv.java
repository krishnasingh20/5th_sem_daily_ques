class Solution {
    static List<Integer> square = new ArrayList<>();
    static int limit = 100000;

    static {
        for(int i = 1; i <= limit; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt == i) {
                square.add(i);
            }
        }
    }

    Boolean[][] dp;
    
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[2][n+1];

        return winner(n, 0);
    }

    public boolean winner(int i, int turn) {
        if(i == 0) {
            return turn == 0 ? false : true;
        }

        if(dp[turn][i] != null) {
            return dp[turn][i];
        }

        boolean ans = turn == 0 ? false : true;

        for(int j: square) {
            if(j > i) {
                break;
            }

            int newTurn = turn == 0 ? 1 : 0;
            boolean curr = winner(i - j, newTurn);

            if(turn == 0 && curr) {
                ans = true;
                break;
            }
            else if(turn == 1 && curr == false) {
                ans = false;
                break;
            }
        }

        return dp[turn][i] = ans;
    }
}