class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int valid = -1;
        int si = 0;
        int ei = 0;
        int min = 0;
        int max = 0;
        long ans = 0;
        while(ei < n) {
            if(nums[ei] < minK || nums[ei] > maxK) {
                valid = ei;
                min = 0;
                max = 0;
                ei++;
                si = ei;
                continue;
            }
            if(nums[ei] == minK) {
                min++;
            }
            if(nums[ei] == maxK) {
                max++;
            }
            while(min > 1 && max > 1) {
                if(nums[si] == minK) {
                    min--;
                }
                if(nums[si] == maxK) {
                    max--;
                }
                si++;
            }
            while(si <= ei && (min == 1 && max >= 2 && nums[si] != minK)) {
                if(nums[si] == maxK) {
                    max--;
                }
                si++;
            }
            while(si <= ei && (min >= 2 && max == 1 && nums[si] != maxK)) {
                if(nums[si] == minK) {
                    min--;
                }
                si++;
            }
            while(min > 0 && max > 0 && nums[si] != minK && nums[si] != maxK) {
                si++;
            }
            if(min > 0 && max > 0) {
                ans += (si - valid);
            }
            ei++;
        }
        return ans;
    }
}