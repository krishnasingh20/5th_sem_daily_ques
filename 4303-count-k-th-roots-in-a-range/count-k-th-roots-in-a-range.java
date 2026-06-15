class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1) {
            return  r - l + 1;
        }

        int ans = 0;

        for(int i = 0; i <= 100000; i++) {
            long x = i;
            boolean flag = false;

            for(int j = 2; j <= k; j++) {
                x = x * i;
                if(x > r) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                break;
            }

            if(x >= l && x <= r) {
                ans++;
            }
        }

        return ans;
    }
}