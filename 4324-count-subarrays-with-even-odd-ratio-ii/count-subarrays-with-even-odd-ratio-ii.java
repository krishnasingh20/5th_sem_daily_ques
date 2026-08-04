class Solution {
    class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n];
        }

        void update(int i, int val) {
            while(i < n) {
                bit[i] += val;
                i += (i & -i);
            }
        }

        int query(int i) {
            int sum = 0;

            while(i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }

            return sum;
        }

        int count(int idx) {
            return query(n-1) - query(idx-1);
        }
    }

    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] arr = new long[n+1];
        long x = 0;
        long y = 0;

        for(int i = 0; i < n; i++) {
            if((nums[i] & 1) == 1) {
                y++;
            }
            else {
                x++;
            }

            long curr = x*b - y*a;
            arr[i+1] = curr;
        }

        long[] temp = arr.clone();
        Arrays.sort(temp);

        HashMap<Long, Integer> compress = new HashMap<>();

        int idx = 1;
        compress.put(temp[0], idx++);

        for(int i = 1; i <= n; i++) {
            if(temp[i] != temp[i-1]) {
                compress.put(temp[i], idx++);
            }
        }

        Fenwick f = new Fenwick(idx);
        long ans = 0;

        f.update(compress.get(0L), 1);

        for(int i = 1; i <= n; i++) {
            int id = compress.get(arr[i]);

            ans += f.count(id);

            f.update(id, 1);
        }

        return ans;
    }
}