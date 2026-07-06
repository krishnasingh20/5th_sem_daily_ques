class Solution {
    public int divisibleGame(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        HashSet<Integer> set = new HashSet<>();
        set.add(2);

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int limit = (int)Math.sqrt(num);
            for(int j = 1; j <= limit; j++) {
                if(num % j == 0) {
                    set.add(j);
                    set.add(num/j);
                }
            }
        }

        long k1 = -1;
        long ans = Long.MIN_VALUE;

        for(int k: set) {
            if(k == 1) {
                continue;
            }

            long curr = 0;
            long max = Long.MIN_VALUE;

            for(int num: nums) {
                if(num % k == 0) {
                    curr += num;
                }
                else {
                    curr -= num;
                }
                max = Math.max(curr, max);
                if(curr < 0) {
                    curr = 0;
                }
            }

            if(k1 == -1 || max > ans || (max == ans && k < k1)) {
                k1 = k;
                ans = max;
            }
        }

        return (int)((ans*k1 + MOD) % MOD);
    }
}