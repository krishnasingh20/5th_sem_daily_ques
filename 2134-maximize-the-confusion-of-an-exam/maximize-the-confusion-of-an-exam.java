class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey, k, 'T'), solve(answerKey, k, 'F'));
    }
    public int solve(String s, int k, char c) {
        int ans = 0;
        int curr = 0;
        int ei = 0;
        int si = 0;
        while(ei < s.length()) {
            if(s.charAt(ei) != c) {
                k--;
            }
            while(k < 0 && si <= ei) {
                if(s.charAt(si) != c) {
                    k++;
                }
                si++;
            }
            ans = Math.max(ans, ei - si+1);
            ei++;
        }
        return ans;
    }
}