class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][201];
        return validate(s.toCharArray(), 0, 0, dp);
    }
    public boolean validate(char[] ch, int i, int curr, Boolean[][] dp) {
        if(i == ch.length) {
            if(curr == 0) {
                return true;
            }
            return false;
        }
        if(dp[i][curr+100] != null) {
            return dp[i][curr+100];
        }
        if(ch[i] == '(') {
            dp[i][curr+100] = validate(ch, i+1, curr+1, dp);
        }
        else if(ch[i] == ')' && curr > 0) {
            dp[i][curr+100] = validate(ch, i+1, curr-1, dp);
        }
        else if(ch[i] == '*') {
            boolean a = validate(ch, i+1, curr, dp);
            boolean b = validate(ch, i+1, curr+1, dp);
            dp[i][curr+100] = (a || b);
            if(curr > 0) {
                boolean c = validate(ch, i+1, curr-1, dp);
                dp[i][curr+100] = (dp[i][curr+100] || c);
            }
        }
        else {
            dp[i][curr+100] = false;
        }
        return dp[i][curr+100];
    }
}