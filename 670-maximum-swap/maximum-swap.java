class Solution {
    public int maximumSwap(int num) {
        if(num <= 10) {
            return num;
        }
        char[] ch = String.valueOf(num).toCharArray();
        int max = 0;
        int idx = -1;
        for(int i = 0; i < ch.length; i++) {
            for(int j = i+1; j < ch.length; j++) {
                if((ch[j]-'0') > (ch[i]-'0')) {
                    if(ch[j]-'0' >= max) {
                        max = ch[j]-'0';
                        idx = j;
                    }
                }
            }
            if(idx != -1) {
                char temp = ch[i];
                ch[i] = (char)(max+'0');
                ch[idx] = temp;
                break;
            }
        }
        if(idx == -1) {
            return num;
        }
        int ans = 0;
        for(int i = 0; i < ch.length; i++) {
            ans = ans * 10 + (ch[i]-'0');
        }
        return ans;
    }
}
// TC--> O(n^2)
// SC--> O(n)