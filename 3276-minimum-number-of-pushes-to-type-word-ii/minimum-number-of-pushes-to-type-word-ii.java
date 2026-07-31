class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        int dist = 0;

        for(char c: word.toCharArray()) {
            freq[c-'a']++;
            if(freq[c-'a'] == 1) {
                dist++;
            }
        }

        if(dist <= 8) {
            return n;
        }

        Arrays.sort(freq);

        int ans = 0;
        int j = 0;
        int place = 1;

        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) {
                break;
            }
            ans += freq[i]*place;
            if(++j == 8) {
                place++;
                j = 0;
            }
        }

        return ans;
    }
}