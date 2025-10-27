class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < bank.length; i++) {
            int curr = 0;
            for(int j = 0; j < bank[i].length(); j++) {
                if(bank[i].charAt(j) == '1') {
                    curr++;
                }
            }
            if(prev == 0) {
                prev = curr;
            }
            else if(curr != 0) {
                ans += prev*curr;
                prev = curr;
            }
        }
        return ans;
    }
}