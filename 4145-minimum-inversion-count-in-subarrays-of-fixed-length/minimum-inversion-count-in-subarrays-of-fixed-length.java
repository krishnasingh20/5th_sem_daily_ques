class Solution {
    class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            this.bit = new int[n+1];
        }

        void update(int i, int val) {
            while(i <= n) {
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
    }
    
    public long minInversionCount(int[] nums, int k) {

        int n = nums.length;

        int[] temp = nums.clone();
        HashMap<Integer, Integer> compress = new HashMap<>();

        Arrays.sort(temp);

        int idx = 1;
        for(int i = 0; i < n; i++) {
            if(!compress.containsKey(temp[i])) {
                compress.put(temp[i], idx++);
            }
        }

        Fenwick f = new Fenwick(idx);

        long curr = 0;

        for(int i = 0; i < k; i++) {
            int id = compress.get(nums[i]);
            curr += (i - f.query(id));
            f.update(id, 1);
        }

        long ans = curr;

        for(int i = k; i < n; i++) {

            int id = compress.get(nums[i-k]);
            curr -= f.query(id-1);
            f.update(id, -1);

            id = compress.get(nums[i]);
            curr += (k - f.query(id) - 1);
            f.update(id, 1);

            ans = Math.min(ans, curr);
        }

        return ans;
    }
}