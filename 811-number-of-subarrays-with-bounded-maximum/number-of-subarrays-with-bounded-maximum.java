class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // in these first i find all subarray with max element less then equal to right and all subarray whose max value is less then left and in last i will substract frist ans with second one 

        // subarray <= right
        int subarray1 = count(nums, right);
        // subarrays < left
        int subarray2 = count(nums, left - 1);
        return subarray1 - subarray2;
    }
    public int count(int[] nums, int max) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int maxValue = -1;
        while(i < nums.length) {
            maxValue = Math.max(maxValue, nums[i]);
            if(maxValue > max) {
                i++;
                j = i;
                maxValue = -1;
            }
            else {
                ans += (i - j + 1);
                i++;
            }
        }
        return ans;
    }
}