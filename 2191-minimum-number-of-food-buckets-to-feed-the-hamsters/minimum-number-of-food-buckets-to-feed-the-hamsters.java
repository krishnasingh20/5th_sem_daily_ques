class Solution {
    public int minimumBuckets(String s) {
        if(s.length() == 1) {
            if(s.charAt(0) == 'H') {
                return -1;
            }
            return 0;
        }
        int ans = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0; i < n;) {
            if(ch[i] == 'x') {
                i++;
                continue;
            }
            if(ch[i] == 'H') {
                boolean prev = false;
                if(i-1 >= 0) {
                    if(ch[i-1] == 'x') {
                        i++;
                        continue;
                    }
                    else if(ch[i-1] == '.') {
                        prev = true;
                    }
                }
                boolean front = false;
                if(i+1 < n && ch[i+1] == '.') {
                    front = true;
                }
                if(!prev && !front) {
                    return -1;
                }
                if(front) {
                    ch[i+1] = 'x';
                }
                ans++;
            }
            i++;
        }
        return ans;
    }
}