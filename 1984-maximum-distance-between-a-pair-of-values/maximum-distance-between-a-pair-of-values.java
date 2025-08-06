class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        while(i < n && j < m) {
            if(nums1[i] > nums2[j]) {
                i++;
                continue;
            }

            ans = Math.max(ans, j - i);
            j++;
        }
        return ans;
    }
}