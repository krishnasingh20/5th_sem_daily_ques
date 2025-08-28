class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
       permutation(tiles, "");
       return count;
    }
    public void permutation(String ques, String ans) {
        if(ques.length() == 0) {
            count++;
            return;
        }
        if(ans.length() > 0) {
            count++;
        }
        for(int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            if(!isPresent(ques, i+1, ch)) {
                String s1 = ques.substring(0,i);
                String s2 = ques.substring(i+1);
                permutation(s1+s2, ans+ch);
            }
        }
    }
    public boolean isPresent(String ques, int idx, char ch) {
        for(int i = idx; i < ques.length(); i++) {
            if(ques.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}