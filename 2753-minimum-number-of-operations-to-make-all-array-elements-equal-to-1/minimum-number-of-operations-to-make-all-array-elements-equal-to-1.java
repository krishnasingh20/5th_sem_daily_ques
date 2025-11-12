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
        if(gcd != 1) {
            return -1;
        }
        if(one > 0) {
            return n - one;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int gcd1 = nums[i];
            int gcd2 = nums[i];
            int leftC = 0;
            int rightC = 0;
            int j = i - 1;
            int k = i+1;
            while(j >= 0 && gcd1 != 1) {
                leftC++;
                gcd1 = GCD(gcd1, nums[j]);
                j--;
            }
            while(k < n && gcd2 != 1) {
                rightC++;
                gcd2 = GCD(gcd2, nums[k]);
                k++;
            }
            if(gcd1 == 1 && gcd2 == 1) {
                ans = Math.min(ans, Math.min(leftC, rightC));
            }
            else if(gcd1 == 1) {
                ans = Math.min(ans, leftC);
            }
            else if(gcd2 == 1) {
                ans = Math.min(ans, rightC);
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