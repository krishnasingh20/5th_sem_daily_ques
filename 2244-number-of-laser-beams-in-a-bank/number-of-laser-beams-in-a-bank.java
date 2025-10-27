class Solution {
    public int numberOfBeams(String[] bank) {
        int[] count = new int[bank.length];
        for(int i = 0; i < bank.length; i++) {
            for(int j = 0; j < bank[i].length(); j++) {
                if(bank[i].charAt(j) == '1') {
                    count[i]++;
                }
            }
        }
        int ans = 0;
        int val = count[0];
        int i = 1;
        while(i < count.length) {
            if(val == 0) {
                val = count[i];
                i++;
            }
            else if(count[i] == 0) {
                i++;
            }
            else {
                ans += (val*count[i]);
                val = count[i];
                i++;
            }
        }
        return ans;
    }
}