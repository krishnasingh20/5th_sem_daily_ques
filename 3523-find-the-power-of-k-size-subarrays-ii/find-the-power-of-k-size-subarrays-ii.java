class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Arrays.fill(ans, -1);
        int consecutive = 1;
        for(int i = 1; i < k; i++) {
            if(nums[i] == nums[i-1]+1) {
                consecutive++;
                continue;
            }
            consecutive = 1;
        }
        for(int i = k-1; i < n; i++) {
            if(i >= k) {
                if(nums[i] == nums[i-1]+1) {
                    consecutive++;
                }
                else {
                    consecutive = 1;
                }
            }
            if(consecutive >= k) {
                ans[i-k+1] = nums[i];
            }
        }
        return ans;
    }
}