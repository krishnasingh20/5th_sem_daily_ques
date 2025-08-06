class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int diff = 0;
            int low = i + 1;
            int high = m - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(nums1[i] <= nums2[mid]) {
                    diff = mid;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            ans = Math.max(ans, diff - i);
        }
        return ans;
    }
}