class Solution {
    boolean[] prime;
    List<Integer> ll = new ArrayList<>();
    public int largestPrime(int n) {
        prime = new boolean[n+1];
        generatePrime(n);
        int curr = 0;
        int ans = 0;
        int i = 0;
        while(i < ll.size()) {
            curr += ll.get(i);
            if(curr > n) {
                break;
            }
            if(isPrime(curr)) {
                ans = curr;
            }
            i++;
        }
        return ans;
    }
    public boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int)Math.sqrt(n);
        for(int i = 5; i <= limit; i += 6) {
            if(n % i == 0 || n %  (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
    public void generatePrime(int n) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    if(prime[j]) {
                        prime[j] = false;
                    }
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(prime[i]) {
                ll.add(i);
            }
        }
    }
}