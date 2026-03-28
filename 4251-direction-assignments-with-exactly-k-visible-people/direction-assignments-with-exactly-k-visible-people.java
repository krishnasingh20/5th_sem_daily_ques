class Solution {
    int mod = 1000000007;
    public int countVisiblePeople(int n, int pos, int k) {
        long[] fact = new long[n+1];
        long[] invFact = new long[n+1];
        precompute(fact, invFact);

        long ans = 0;
        int l = pos;
        int r = (n - pos - 1);

        for(int i = 0; i <= k; i++) {
            int k1 = i;
            int k2 = k - i;
            if(k1 <= l && k2 <= r) {
                long temp1 = (((fact[l] * invFact[k1]) % mod) * invFact[(l-k1)]) % mod;
                long temp2 = (((fact[r] * invFact[k2]) % mod) * invFact[(r-k2)]) % mod;
                ans = (ans + (temp1 * temp2) % mod);
            }
        }

        return (int)((ans*2)%mod);
    }

    public void precompute(long[] fact, long[] invfact) {
        int n = fact.length;

        // factorial calculating
        fact[0] = 1;
        for(int i = 1; i < n; i++) {
            fact[i] = (fact[i-1]*i) % mod;
        }

        // inverse factorial calculating
        invfact[n-1] = inversefact(fact[n-1]);
        for(int i = n-2; i >= 0; i--) {
            invfact[i] = (invfact[i+1]*(i+1)) % mod;
        }
    }

    public long inversefact(long n) {
        return power(n, mod-2);
    }

    public long power(long a, long b) {
        if(b == 0) {
            return 1;
        }

        long ans = power(a, b/2);

        ans = (ans * ans) % mod;

        if((b & 1) == 1) {
            ans = (ans * a) % mod;
        }

        return ans;
    }
}