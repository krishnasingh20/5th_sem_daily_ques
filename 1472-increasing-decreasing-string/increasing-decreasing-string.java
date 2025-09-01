class Solution {
    StringBuilder str = new StringBuilder();
    public String sortString(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        solve(freq);
        return str.toString();
    }
    public void solve(int[] freq) {
        boolean flag = true;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                str.append((char)(i+'a'));
                freq[i]--;
                flag = false;
            }
        }
        if(flag) {
            return;
        }
        flag = true;
        for(int i = 25; i >= 0; i--) {
            if(freq[i] > 0) {
                flag = false;
                str.append((char)(i+'a'));
                freq[i]--;
            }
        }
        if(flag) {
            return;
        }
        solve(freq);
    }
}