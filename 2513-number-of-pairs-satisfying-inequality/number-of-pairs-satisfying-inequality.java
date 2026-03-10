class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        for(int i = 0; i < n; i++) {
            nums1[i] = nums1[i] - nums2[i];
            nums2[i] = nums1[i];
        }
        TreeMap<Integer, Integer> compress = new TreeMap<>();
        int idx = 1;
        Arrays.sort(nums2);
        for(int i = 0; i < n; i++) {
            if(!compress.containsKey(nums2[i])) {
                compress.put(nums2[i], idx++);
            }
        }
        Fenwick f = new Fenwick(idx);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums1[i] + diff;
            Integer id = compress.floorKey(curr);
            if(id != null) {
                ans += f.query(compress.get(id));
            }
            f.update(compress.get(nums1[i]), 1);
        }
        return ans;
    }
    class Fenwick {
        int n;
        int[] bit;
        public Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }
        public void update(int i, int val) {
            while(i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }
        public int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
}