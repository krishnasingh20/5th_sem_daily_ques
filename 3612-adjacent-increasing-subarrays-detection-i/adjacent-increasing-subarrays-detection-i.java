class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1; i < n; i++) {
            if(nums.get(i) > nums.get(i-1)) {
                left[i] = 1 + left[i-1];
            }
            else {
                left[i] = 1;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            if(nums.get(i) < nums.get(i+1)) {
                right[i] = 1 + right[i+1];
            }
            else {
                right[i] = 1;
            }
        }
        for(int i = 0; i < n - 1; i++) {
            if(left[i] >= k && right[i+1] >= k) {
                return true;
            }
        }
        return false;
    }
}