class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int min = -1;//it will hold nearest minK value index in nums
        int max = -1;//it will hold nearest maxK value index in nums
        int start = -1;//it will represent the boundary after which every element are greater then equal to minK and less then equal to maxK for calculating numder of subarrays

        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            
            if (nums[i] < minK || nums[i] > maxK) {
                start = i;
                min = max = -1;
                continue;
            }

            if (nums[i] == minK) {
                min = i;
            }

            if (nums[i] == maxK) {
                max = i;
            }

            if (min != -1 && max != -1) {
                int end = Math.min(min, max);
                ans += (end - start);
            }
        }

        return ans;
    }
}