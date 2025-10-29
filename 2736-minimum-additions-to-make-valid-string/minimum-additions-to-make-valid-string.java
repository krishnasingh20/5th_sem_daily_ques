class Solution {
    public int addMinimum(String word) {
        int ans = 0;
        int i = 0;
        while(i < word.length()) {
            if(word.charAt(i) == 'a') {
                if(i+1 == word.length()) {
                    ans += 2;
                    i++;
                }
                else if(i+2 == word.length()) {
                    if(word.charAt(i+1) == 'b' || word.charAt(i+1) == 'c') {
                        ans += 1;
                        i += 2;
                    }
                    else {
                        ans += 2;
                        i++;
                    }
                }
                else {
                    if(word.charAt(i+1) == 'b' && word.charAt(i+2) == 'c') {
                        i += 3;
                    }
                    else if(word.charAt(i+1) == 'b' && word.charAt(i+2) != 'c') {
                        ans++;
                        i += 2;
                    }
                    else if(word.charAt(i+1) == 'c') {
                        ans++;
                        i += 2;
                    }
                    else {
                        i++;
                        ans += 2;
                    }
                }
            }
            else if(word.charAt(i) == 'b') {
                if(i+1 == word.length()) {
                    ans += 2;
                    i++;
                }
                else if(word.charAt(i+1) == 'c') {
                    ans++;
                    i += 2;
                }
                else {
                    ans += 2;
                    i++;
                }
            }
            else {
                ans += 2;
                i++;
            }
        }
        return ans;
    }
}