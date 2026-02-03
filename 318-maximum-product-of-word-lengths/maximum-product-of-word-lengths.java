class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        generateMask(words, mask);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
    private void generateMask(String[] words, int[] mask) {
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            int curr = 0;
            for(int j = 0; j < s.length(); j++) {
                int x = s.charAt(j)-'a';
                curr |= (1<<x);
            }
            mask[i] = curr;
        }
    }
}