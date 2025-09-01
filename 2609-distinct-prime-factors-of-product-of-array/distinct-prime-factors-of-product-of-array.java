class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int j = 2; j * j <= num; j++) {
                if(num % j == 0) {
                    set.add(j);
                    while(num % j == 0) {
                        num /= j;
                    }
                }
            }
            if(num > 1) {
                set.add(num);
            }
        }
        int ans = 0;
        for(int num: set) {
            if(isPrime(num)) {
                ans++;
            }
        }
        return ans;
    }
    public boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        if(num == 2 || num == 3) {
            return true;
        }
        if(num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int limit = (int)Math.sqrt(num);
        for(int i = 5; i <= limit; i += 6) {
            if(num % i == 0 || num % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}