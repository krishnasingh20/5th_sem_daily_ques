class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        for(char ch: s.toCharArray()) {
            set.add(ch);
        }
        int ans = 0;
        int ei = 0;
        int si = 0;
        int diff = 0;
        for(char ch : set) {
            ei = 0;
            si = 0;
            diff = 0;
            while(ei < s.length()) {
                if(s.charAt(ei) != ch) {
                    diff++;
                }
                while(diff > k) {
                    if(s.charAt(si) != ch) {
                        diff--;
                    }
                    si++;
                }
                ans = Math.max(ans, (ei-si+1));
                ei++;
            }
        }
        return ans;
    }
}