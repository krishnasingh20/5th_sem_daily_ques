class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        boolean[] visited = new boolean[26];
        int[][] prefix = new int[n+1][26];
        for(int i = 0; i < n; i++) {
            prefix[i+1][s.charAt(i)-'a'] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 26; j++) {
                prefix[i][j] += prefix[i-1][j];
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!visited[c-'a']) {
                int x = map.get(c);
                if(x - i - 1 >= 1) {
                    int cnt = 0;
                    for(int j = 0; j < 26; j++) {
                        if(prefix[x][j] - prefix[i+1][j] >= 1) {
                            cnt++;
                        }
                    }
                    System.out.println(cnt);
                    ans += cnt;
                }
                visited[c-'a'] = true;
            }
        }
        return ans;
    }
}