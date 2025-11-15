class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                nums[i] = 1;
                flag = false;
            }
            else {
                nums[i] = -1;
            }
            if(i > 0) {
                nums[i] = nums[i]+nums[i-1];
            }
        }
        if(flag) {
            return 0;
        }
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            arr[i+1] = nums[i];
        }
        int id = 1;//coordibate compresion required because negative indexing not possible in fenwick tree so mapping unique id with each prefixsum
        HashMap<Integer, Integer> compress = new HashMap<>();
        Arrays.sort(arr);//to map idx for evry unique prefix sum
        for(int x: arr) {
            if(!compress.containsKey(x)) {
                compress.put(x, id++);
            }
        }
        Fenwick ft = new Fenwick(id);
        long ans = 0;
        ft.update(compress.get(0), 1);
        for(int x: nums) {
            int idx = compress.get(x);
            ans += ft.query(idx - 1);
            ft.update(idx, 1);
        }
        return ans;
    }
    class Fenwick {
        int n;
        long[] bit;
        Fenwick(int n) {
            this.n = n;
            bit = new long[n+1];
        }
        void update(int i, long delta) {
            while(i <= n) {
                bit[i] += delta;
                i += (i & -i);
            }
        }
        long query(int i) {
            long sum = 0;
            while(i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
}