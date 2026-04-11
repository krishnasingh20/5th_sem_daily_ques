class Solution {
    static final long MOD = 1000000007;
    long[] pow = new long[10001];
    long[] prefix = new long[10001];
    public int maxValue(int[] nums1, int[] nums0) {

        precompute();
        
        int n = nums1.length;

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = nums0[i];
            arr[i][1] = nums1[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        long ans = 0;
        long p = 1;

        boolean flag = false;
        List<Integer> ll = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            
            if(arr[i][0] == 0 && arr[i][1] > 0) {
                ll.add(arr[i][1]);
                continue;
            }
            
            if(arr[i][0] > 0) {
                if(!flag) {
                    p = (p * pow[arr[i][0]-1]) % MOD;
                }
                else {
                    p = (p * pow[arr[i][0]]) % MOD;
                }
                flag = true;
            }

            if(arr[i][1] > 0) {
                if(!flag) {
                    ans = (ans + ((p * prefix[arr[i][1]-1]) % MOD)) % MOD;
                    p = (p * pow[arr[i][1]-1]) % MOD;
                }
                else {
                    p = (p * 2) % MOD;
                    ans = (ans + ((p * prefix[arr[i][1]-1]) % MOD)) % MOD;
                    p = (p * pow[arr[i][1]-1]) % MOD;
                }
                flag = true;
            }
        }

        for(int i = 0; i < ll.size(); i++) {
            if(!flag) {
                ans = (ans + ((p * prefix[ll.get(i)-1]) % MOD)) % MOD;
                p = (p * pow[ll.get(i)-1]) % MOD;
            }
            else {
                p = (p * 2) % MOD;
                ans = (ans + ((p * prefix[ll.get(i)-1]) % MOD)) % MOD;
                p = (p * pow[ll.get(i)-1]) % MOD;
            }
            flag = true;
        }

        return (int)(ans % MOD);
    }

    public void precompute() {
        pow[0] = 1;
        for(int i = 1; i <= 10000; i++) {
            pow[i] = (pow[i-1] * 2) % MOD;
        }

        prefix[0] = 1;

        for(int i = 1; i <= 10000; i++) {
            prefix[i] = (prefix[i-1] + pow[i]) % MOD;
        }
    }
}