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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }

        int ans = 0;
        int j = 0;
        int place = 1;

        while(!pq.isEmpty()) {
            int[] rv = pq.poll();
            ans += rv[1]*place;
            if(++j == 8) {
                place++;
                j = 0;
            }
        }

        return ans;
    }
}