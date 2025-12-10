class Solution {
    Boolean[][] dp = new Boolean[101][101];
    public boolean checkValidString(String s) {
        return validate(s.toCharArray(), 0, 0);
    }
    public boolean validate(char[] ch, int i, int curr) {
        if(i == ch.length) {
            if(curr == 0) {
                return true;
            }
            return false;
        }
        if(dp[i][curr] != null) {
            return dp[i][curr];
        }
        if(ch[i] == '(') {
            dp[i][curr] = validate(ch, i+1, curr+1);
        }
        else if(ch[i] == ')' && curr > 0) {
            dp[i][curr] = validate(ch, i+1, curr-1);
        }
        else if(ch[i] == '*') {
            boolean a = validate(ch, i+1, curr);
            boolean b = validate(ch, i+1, curr+1);
            dp[i][curr] = (a || b);
            if(curr > 0) {
                boolean c = validate(ch, i+1, curr-1);
                dp[i][curr] = (dp[i][curr] || c);
            }
        }
        else {
            dp[i][curr] = false;
        }
        return dp[i][curr];
    }
}