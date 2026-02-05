class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int cnt = 0;
        for(int i = 0; i < k; i++) {
            if(nums[i] < 0) {
                cnt++;
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        ans[0] = cnt < x?0:getFreq(x);
        for(int i = k; i < n; i++) {
            if(nums[i-k] < 0) {
                map.put(nums[i-k], map.get(nums[i-k])-1);
                cnt--;
            }
            if(nums[i] < 0) {
                cnt++;
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
            ans[i-k+1] = cnt < x?0:getFreq(x);
        }
        return ans;
    }
    private int getFreq(int x) {
        int cnt = 0;
        for(int key: map.keySet()) {
            cnt += map.get(key);
            if(cnt >= x) {
                return key;
            }
        }
        return -1;
    }
}