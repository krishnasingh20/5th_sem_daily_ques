class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        for(int i = 0; i < n; i++) {
            nums1[i] = nums1[i] - nums2[i];
            nums2[i] = nums1[i];
        }
        ArrayList<int[]> compress = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums2);
        compress.add(new int[]{nums2[0], 1});
        map.put(nums2[0], 1);
        int idx = 1;
        for(int i = 1; i < n; i++) {
            if(compress.get(idx-1)[0] != nums2[i]) {
                map.put(nums2[i], ++idx);
                compress.add(new int[]{nums2[i], idx});
            }
        }
        Fenwick f = new Fenwick(idx);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums1[i] + diff;
            int id = binarySearch(compress, curr);
            if(id != -1) {
                ans += f.query(compress.get(id)[1]);
            }
            f.update(map.get(nums1[i]), 1);
        }
        return ans;
    }
    private int binarySearch(ArrayList<int[]> compress, int val) {
        int idx = -1;
        int low = 0;
        int high = compress.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(compress.get(mid)[0] <= val) {
                idx=  mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
    class Fenwick {
        int n;
        int[] bit;
        Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
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
}