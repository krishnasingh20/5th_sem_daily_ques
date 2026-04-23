class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, long[]> map = new HashMap<>();

        for(int i = n-1; i >= 0; i--) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new long[]{0, 0L});
            }
            long[] a = map.get(nums[i]);
            a[0] += 1;
            a[1] += i;
        }

        HashMap<Integer, long[]> map1 = new HashMap<>();
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            long[] a = map.get(nums[i]);
            a[0]--;
            a[1] -= i;
            long curr = 0;
            curr += Math.abs((long)a[0]*i - a[1]);

            if(!map1.containsKey(nums[i])) {
                map1.put(nums[i], new long[]{0, 0L});
            }

            a = map1.get(nums[i]);
            curr += ((long)a[0]*i - a[1]);
            a[0] += 1;
            a[1] += i;
            ans[i] = curr;
        }

        return ans;
    }
}