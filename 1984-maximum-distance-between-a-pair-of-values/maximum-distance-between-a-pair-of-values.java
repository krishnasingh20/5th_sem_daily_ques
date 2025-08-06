class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;
            int ans1 = 0;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(nums2[mid] >= nums1[i]) {
                    ans1 = mid;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            if( ans1 >= i) {
                ans = Math.max(ans, ans1 - i);
            }
            // ans = Math.max(ans, ans1 - i);
        }
        return ans;
    }
}