class Solution {

    public boolean repeatedSubstringPattern(String s) {
        return isRepeatedPattern(s);
    }

    public static boolean isRepeatedPattern(String s) {
        int n = s.length();

        List<Integer> factor = generateFactor(s, n);

        int MOD = 1000000007;

        long[] arr = new long[n];
        long[] pow = new long[n + 2];

        pow[0] = 1;

        for (int i = 1; i <= n + 1; i++) {
            pow[i] = (pow[i - 1] * 31) % MOD;
        }

        long p = 1;

        arr[0] = (p * (s.charAt(0) - 'a')) % MOD;

        for (int i = 1; i < n; i++) {
            p = (p * 31) % MOD;
            arr[i] = ((s.charAt(i) - 'a') * p) % MOD;
        }

        // prefix sum hash
        for (int i = 1; i < n; i++) {
            arr[i] = (arr[i] + arr[i - 1]) % MOD;
        }

        for (int k : factor) {

            long pat = arr[k - 1];

            int i = 2 * k - 1;

            boolean flag = true;

            for (; i < n; i += k) {
                long curr = arr[i] - arr[i - k];

                // handle negative
                if (curr < 0) curr += MOD;

                if (curr != (pat * pow[i - k + 1]) % MOD) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        return false;
    }

    public static List<Integer> generateFactor(String s, int n) {
        List<Integer> factor = new ArrayList<>();

        int limit = (int) Math.sqrt(n);

        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                factor.add(i);
                if (i != n / i) {
                    factor.add(n / i);
                }
            }
        }

        Collections.sort(factor);

        // remove n itself
        factor.remove(factor.size() - 1);

        return factor;
    }
}