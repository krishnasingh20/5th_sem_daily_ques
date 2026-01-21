class Solution {
    List<Integer> primes;
    int n;
    int len;
    public boolean primeSubOperation(int[] nums) {
        primes = new ArrayList<>();
        n = nums.length;
        len = 0;
        for(int i = 0; i < n; i++) {
            len = Math.max(len, nums[i]);
        }
        sieve();
        int prev = 0;
        for(int i = 0; i < n; i++) {
            int diff = nums[i] - prev;
            int prime = lowerBound(diff);
            if(prime != -1) {
                nums[i] -= prime;
            }
            prev = nums[i];
        }
        for(int i = 1; i < n; i++) {
            if(nums[i] <= nums[i-1]) {
                return false;
            }
        }
        return true;
    }
    public int lowerBound(int target) {
        int low = 0;
        int high = primes.size() - 1;
        int prime = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(primes.get(mid) < target) {
                prime = primes.get(mid);
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return prime;
    }
    public void sieve() {
        boolean[] isPrime = new boolean[len+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i <= len; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= len; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i <= len; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
    }
}