class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int gcd = nums[0];
        int one = 0;
        for(int num: nums) {
            if(num == 1) {
                one++;
            }
            gcd = GCD(gcd, num);
        }
        if(one > 0) {
            return n - one;
        }
        if(gcd != 1) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            gcd = nums[i];
            for(int j = i+1; j < n; j++) {
                gcd = GCD(gcd, nums[j]);
                if(gcd == 1) {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }
        }
        return ans + (n-1);
    }
    public int GCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}