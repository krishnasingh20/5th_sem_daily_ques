class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(nums, mid) >= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int isPossible(int[] nums, int mid) {
        int ei = 0;
        int si = 0;
        int count = 0;
        while(ei < nums.length) {
            while(nums[ei]-nums[si] > mid && si <= ei) {
                si++;
            }
            count += (ei - si);
            ei++;
        }
        return count;
    }
}