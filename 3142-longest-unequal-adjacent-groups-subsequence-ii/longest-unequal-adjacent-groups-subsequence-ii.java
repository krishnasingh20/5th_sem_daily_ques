class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[][] sub = new int[n][2];
        sub[0][0] = -1;
        sub[0][1] = 1;
        int max = 1;
        int idx = 0;
        for(int i = 1; i < n; i++) {
            int max1 = 0;
            int idx1 = -1;
            for(int j = 0; j < i; j++) {
                if(valid(i, j, words, groups)) {
                    if(sub[j][1] >= max1) {
                        max1 = sub[j][1];
                        idx1 = j;
                    }
                }
            }
            if(idx1 == -1) {
                sub[i][0] = -1;
                sub[i][1] = 1;
            }
            else {
                sub[i][0] = idx1;
                sub[i][1] = max1+1; 
            }
            if(sub[i][1] > max) {
                max = sub[i][1];
                idx = i;
            }
        }
        List<String> ans = new ArrayList<>();
        while(idx != -1) {
            ans.add(words[idx]);
            idx = sub[idx][0];
        }
        Collections.reverse(ans);
        return ans;
    }
    public boolean valid(int i, int j, String[] words, int[] groups) {
        if(words[i].length() != words[j].length() || groups[i] == groups[j]) {
            return false;
        }
        int ham = hammingDis(words[i], words[j]);
        return ham != 1?false:true;
    }
    public int hammingDis(String s1, String s2) {
        int c = 0;
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                c++;
            }
            i++;
            j++;
        }
        return c;
    }
}