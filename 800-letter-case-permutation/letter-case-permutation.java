class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        permu(s, 0);
        return ans;
    }
    public void permu(String s, int i) {
        if(i == s.length()) {
            ans.add(s);
            return;
        }
        if(Character.isDigit(s.charAt(i))) {
            permu(s, i+1);
            return;
        }
        char c = s.charAt(i);
        char c1 = Character.toUpperCase(c);
        char c2 = Character.toLowerCase(c);
        permu(s.substring(0, i)+c1+s.substring(i+1), i+1);
        permu(s.substring(0, i)+c2+s.substring(i+1), i+1);
    }
}