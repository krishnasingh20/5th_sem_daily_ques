class Solution {
    int[] freq = new int[101];
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int cnt = 0;
        for(int i = 0; i < k; i++) {
            if(nums[i] < 0) {
                cnt++;
                freq[nums[i]+50]++;
            }
        }
        ans[0] = cnt < x?0:getFreq(x);
        for(int i = k; i < n; i++) {
            if(nums[i-k] < 0) {
                freq[nums[i-k]+50]--;
                cnt--;
            }
            if(nums[i] < 0) {
                cnt++;
                freq[nums[i]+50]++;
            }
            ans[i-k+1] = cnt < x?0:getFreq(x);
        }
        return ans;
    }
    private int getFreq(int x) {
        int cnt = 0;
        for(int i = 0; i < 101; i++) {
            cnt += freq[i];
            if(cnt >= x) {
                return i-50;
            }
        }
        return -1;
    }
}