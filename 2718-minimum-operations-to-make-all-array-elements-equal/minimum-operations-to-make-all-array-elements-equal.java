class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> ll = new ArrayList<>();
        long[] prefix = new long[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i]+nums[i];
        }
        for(int i = 0; i < queries.length; i++) {
            long ans = 0;
            int idx = binarySearch(nums, 0, nums.length - 1, queries[i]);
            System.out.println(idx);
            if(idx == -1) {
                ans += ((long)queries[i]*nums.length - prefix[nums.length]);
            }
            else {
                System.out.println(prefix[idx+1]);
                ans += Math.abs(queries[i]-nums[idx]);
                ans += Math.abs((long)queries[i]*(idx) - prefix[idx]);
                ans += Math.abs((long)queries[i]*(nums.length - (idx+1)) - (prefix[nums.length] - prefix[idx+1]));
            }
            ll.add(ans);
        }
        return ll;
    }
    public int binarySearch(int[] nums, int low, int high, int val) {
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] >= val) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}