class Solution {
    public int maximum69Number (int num) {
        int c = -1;
        int idx = 1;
        int temp = num;
        while(temp > 0) {
            int rem = temp % 10;
            if(rem == 6) {
                c = idx;
            }
            idx++;
            temp /= 10;
        }
        System.out.println(c);
        if(c == -1) {
            return num;
        }
        int ans = 0;
        temp = num;
        idx = 1;
        int mul = 1;
        while(temp > 0) {
            int rem = temp % 10;
            if(c == idx) {
                ans += (9 * mul);
            }
            else {
                ans += (rem * mul);
            }
            idx++;
            temp /= 10;
            mul *= 10;
        }
        return ans;
    }
}