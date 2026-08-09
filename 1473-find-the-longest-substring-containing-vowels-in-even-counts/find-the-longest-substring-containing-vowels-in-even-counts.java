class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();

        int[] freq = new int[5];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int ans = 0;

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'a') {
                freq[0] = (freq[0] + 1) % 2;
            }
            else if(c == 'e') {
                freq[1] = (freq[1] + 1) % 2;
            }
            else if(c == 'i') {
                freq[2] = (freq[2] + 1) % 2;
            }
            else if(c == 'o') {
                freq[3] = (freq[3] + 1) % 2;
            }
            else if(c == 'u') {
                freq[4] = (freq[4] + 1) % 2;
            }

            int mask = 0;

            for(int j = 0; j < 5; j++) {
                if(freq[j] == 1) {
                    mask |= (1 << j);
                }
            }

            if(map.containsKey(mask)) {
                ans = Math.max(ans, i - map.get(mask));
            }
            else {
                map.put(mask, i);
            }
        }

        return ans;
    }
}