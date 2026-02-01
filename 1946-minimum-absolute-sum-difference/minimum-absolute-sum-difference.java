class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums1) {
            set.add(num);
        }
        int n = nums1.length;
        long ans  = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.abs(nums1[i]-nums2[i]);
        }
        long ans1 = ans;
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(nums1[i]-nums2[i]);
            Integer lb = set.floor(nums2[i]);
            Integer ub = set.ceiling(nums2[i]);
            if(lb != null) {
                ans1 = Math.min(ans1, ans-curr+Math.abs(lb-nums2[i]));
            }
            if(ub != null) {
                ans1 = Math.min(ans1, ans-curr+Math.abs(ub-nums2[i]));
            }
        }
        ans = (Math.min(ans, ans1)) % 1000000007;
        return (int)ans;
    }
}