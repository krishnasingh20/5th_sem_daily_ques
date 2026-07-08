class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        if(n <= 1) {
            return s;
        } 

        long[] arr1 = new long[n];
        long[] pow = new long[n];
        pow[0] = 1;
        long pr = 31;
        long p = 31;
        long MOD = 1000000007;
        arr1[0] = s.charAt(0)-'a'+1;

        for(int i = 1; i < n; i++) {
            pow[i] = p;
            arr1[i] = (arr1[i-1] + ((s.charAt(i)-'a'+1)*p) % MOD) % MOD;
            p = p * pr % MOD;
        }

        long[] arr2 = new long[n];
        p = 31;
        arr2[n-1] = s.charAt(n-1)-'a'+1;

        for(int i = n - 2; i >= 0; i--) {
            arr2[i] = (arr2[i+1] + ((s.charAt(i)-'a'+1)*p) % MOD) % MOD;
            p = p * pr % MOD;
        }

        if(arr1[n-1] == arr2[0]) {
            return s;
        }

        int mid = (n-1)/2;
        int len = (s.charAt(0) == s.charAt(1)) ? n - 2 : n - 1;

        for(int i = mid; i >= 0; i--) {
            //odd length
            int l = i-1;  
            int r = i + 1;
            if(l >= 0) {
                int idx = n - 2*i - 1;
                long left = arr1[l] * pow[idx] % MOD;
                long right = (arr2[r] - (2*i+1 < n ? arr2[2*i+1] : 0) + MOD) % MOD;
                if(left == right) {
                    len = Math.min(idx, len);
                }
            }
            //even length
            if(s.charAt(i) == s.charAt(i+1) && n-i-2 >= i) {
                l = i - 1;
                if(l >= 0) {
                    int idx = n - 2*i - 2;
                    long left = arr1[l] * pow[idx] % MOD;
                    long right = (arr2[i+2] - (2*i+2 < n ? arr2[2*i+2] : 0) + MOD) % MOD;
                    if(left == right) {
                        len = Math.min(idx, len);
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--) {
            if(len == 0) {
                break;
            }
            sb.append(s.charAt(i));
            len--;
        }
        sb.append(s);

        return sb.toString();
    }
}