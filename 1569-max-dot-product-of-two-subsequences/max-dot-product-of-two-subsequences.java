class Solution {
    Long[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new Long[nums1.length][nums2.length];
        return (int)maxDot(nums1, nums2, 0, 0);
    }
    public long maxDot(int[] nums1, int[] nums2, int i, int j) {
        if(i == nums1.length || j == nums2.length) {
            return Long.MIN_VALUE;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        long take = (long)nums1[i]*nums2[j];
        long next = maxDot(nums1, nums2, i+1, j+1);
        if(next > 0) {
            take += next;
        }
        long skip1 = maxDot(nums1, nums2, i+1, j);
        long skip2 = maxDot(nums1, nums2, i, j+1);
        return dp[i][j] = Math.max(take, Math.max(skip1, skip2));
    }
}