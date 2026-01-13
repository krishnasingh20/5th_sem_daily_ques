class Solution {
    boolean[] prime;
    List<Integer> ll = new ArrayList<>();
    public int largestPrime(int n) {
        prime = new boolean[n+1];
        generatePrime(n);
        for(int i = ll.size()-1; i >= 0; i--) {
            int num = ll.get(i);
            if(possible(num)) {
                return num;
            }
        }
        return 0;
    }
    public boolean possible(int n) {
        int curr = 0;
        int i = 0;
        while(i < ll.size() && curr < n) {
            curr += ll.get(i);
            i++;
        }
        return curr == n;
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