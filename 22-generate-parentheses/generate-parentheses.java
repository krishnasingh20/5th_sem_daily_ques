class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
        generateParentheses(n, 0, 0, "", ll);
        return ll;
    }
    public void generateParentheses(int n, int open, int close, String ans, List<String> ll) {
        if(open == n && close == n) {
            ll.add(ans);
            return;
        }
        if(open < n) {
            generateParentheses(n, open+1, close, ans+'(', ll);
        }
        if(close < open) {
            generateParentheses(n, open, close+1, ans+')', ll);
        }
    }
}