class Solution {
    List<String> ll = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        word(s, set, 0, 0, "");
        return ll;
    }
    public void word(String s, HashSet<String> set, int i, int j, String ans) {
        if(i == s.length() && j == s.length()) {
            ll.add(ans);
            return;
        }
        if(j >= s.length()) {
            return;
        }
        String s1 = s.substring(i, j+1);
        if(set.contains(s1)) {
            if(ans.length() == 0) {
                word(s, set, j+1, j+1, ans+s1);
            }
            else {
                word(s, set, j+1, j+1, ans+" "+s1);
            }
            word(s, set, i, j+1, ans);
        }
        else {
            word(s, set, i, j+1, ans);
        }
    }
}