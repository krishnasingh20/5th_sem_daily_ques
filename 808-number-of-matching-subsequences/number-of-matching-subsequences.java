class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int[][] arr = new int[n+1][26];

        for(int i = 0; i < 26; i++) {
            arr[n][i] = -1;
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 26; j++) {
                arr[i][j] = arr[i+1][j];
            }
            arr[i][s.charAt(i)-'a'] = i;
        }

        int m = words.length;
        int ans = 0;

        for(int i = 0; i < m; i++) {
            int j = 0;
            int k = 0;
            while(j < words[i].length()) {
                int x = words[i].charAt(j) - 'a';
                if(arr[k][x] == -1) {
                    break;
                }
                j++;
                k = arr[k][x] + 1;
            }

            if(j == words[i].length()) {
                ans++;
            }
        }

        return ans;
    }
}