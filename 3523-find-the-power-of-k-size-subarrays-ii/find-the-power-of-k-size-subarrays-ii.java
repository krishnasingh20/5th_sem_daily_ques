class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int[] consecutive = new int[n];
        consecutive[0] = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]+1) {
                consecutive[i] = consecutive[i-1]+1;
            }
            else {
                consecutive[i] = 1;
            }
        }
        for(int i = k-1; i < n; i++) {
            if(consecutive[i] >= k) {
                ans[i-k+1] = nums[i];
            }
            else {
                ans[i-k+1] = -1;
            }
        }
        return ans;
    }
}