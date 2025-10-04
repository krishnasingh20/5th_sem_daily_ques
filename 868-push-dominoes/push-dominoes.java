class Solution {
    public String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int i = 0;
        int j = -1;
        int n = ch.length;
        while(i < n) {
            if(ch[i] == 'L') {
                if(j != -1) {
                    while(j <= i) {
                        ch[j] = 'L';
                        j++;
                    }
                    j = -1;
                }
                i++;
            }
            else if(ch[i] == '.') {
                if(j == -1) {
                    j = i;
                }
                i++;
            }
            else {
                j = -1;
                while(i < n - 1 && ch[i] == ch[i+1]) {
                    i++;
                }
                int k = i + 1;
                while(k < n && ch[k] == '.') {
                    k++;
                }
                if(k >= n) {
                    for(int l = i; l < n; l++) {
                        ch[l] = 'R';
                    }
                    i = k;
                }
                else if(k < n && (ch[k] == 'R' || ch[k] == '.')) {
                    for(int l = i; l <= k; l++) {
                        ch[l] = 'R';
                    }
                    if(ch[k] == 'R') {
                        i = k;
                    }
                    else {
                        i = k+1;
                    }
                }
                else {
                    int l = i;
                    int m = k;
                    while(l < m) {
                        ch[l] = 'R';
                        ch[m] = 'L';
                        l++;
                        m--;
                    }
                    i = k + 1;
                }
            }
        }
        return new String(ch);
    }
}