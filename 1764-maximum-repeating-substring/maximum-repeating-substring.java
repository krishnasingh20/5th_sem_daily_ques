class Solution {
    public int maxRepeating(String sequence, String word) {
        if(word.length() > sequence.length()) {
            return 0;
        }
        if(word.equals(sequence)) {
            return 1;
        }
        int max = 0;
        int m = sequence.length();
        int n = word.length();
        for(int i = 0; i < m; i++) {
            if(sequence.charAt(i) != word.charAt(0) || n > m - i) {
                continue;
            }
            int c = 0;
            for(int j = i; j < m; j += n) {
                int k = j;
                int l = 0;
                while(k < m && l < n && word.charAt(l) == sequence.charAt(k)) {
                    k++;
                    l++;
                }
                if(l == n) {
                    c++;
                }
                else {
                    c = 0;
                }
                max = Math.max(max, c);
            }
        }
        return max;
    }
}