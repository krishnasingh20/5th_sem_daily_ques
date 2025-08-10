class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        Arrays.sort(ch);
        boolean[] visit = new boolean[ch.length];
        return backtrack(ch, visit, "");
    }
    public boolean backtrack(char[] ch, boolean[] visit, String ans) {
        if(ans.length() == ch.length) {
            return isPowerOfTwo(Integer.parseInt(ans));
        }
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '0' && ans.length() == 0) {
                continue;
            }
            if(i > 0 && ch[i] == ch[i - 1] && visit[i]) {
                continue;
            }
            if(!visit[i]) {
                visit[i] = true;
                if(backtrack(ch, visit, ans + ch[i])) {
                    return true;
                }
                visit[i] = false;
            }
        }
        return false;
    }
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
}