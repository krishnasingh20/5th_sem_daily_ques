class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ll = new ArrayList<>();
        int prev = 0;
        if(groups[0] == 0) {
            prev = 1;
        }
        for(int i = 0; i < groups.length; i++) {
            if(groups[i] != prev) {
                ll.add(words[i]);
                prev = groups[i];
            }
        }
        return ll;
    }
}