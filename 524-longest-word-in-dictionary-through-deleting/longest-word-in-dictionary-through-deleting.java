class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for(int i = 0; i < dictionary.size(); i++) {
            String s1 = dictionary.get(i);
            if(possible(s1, s)) {
                if(ans.length() == 0 || ans.length() < s1.length()) {
                    ans = s1;
                }
                else if(ans.length() == s1.length() && ans.compareTo(s1) > 0) {
                    ans = s1;
                }
            }
        }
        return ans;
    }
    public boolean possible(String s1, String s) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < s1.length()) {
            if(s1.charAt(j) == s.charAt(i)) {
                j++;
            }
            i++;
        }
        return j == s1.length();
    }
}