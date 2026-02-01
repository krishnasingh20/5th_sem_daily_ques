class Solution {
    int[] arr;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        arr = nums1.clone();
        Arrays.sort(arr);
        long ans = 0;
        int n = nums1.length;
        for(int i = 0; i < n; i++) {
            ans += Math.abs(nums1[i]-nums2[i]);
        }
        long ans1 = ans;
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(nums1[i]-nums2[i]);
            int idx1 = lowerBound(nums2[i]);
            int idx2 = upperBound(nums2[i]);
            if(idx1 != -1) {
                ans1 = Math.min(ans1, ans-curr+Math.abs(arr[idx1]-nums2[i]));
            }
            if(idx2 != -1) {
                ans1 = Math.min(ans1, ans-curr+Math.abs(arr[idx2]-nums2[i]));
            }
        }
        ans = Math.min(ans, ans1) % 1000000007;
        return (int)ans;
    }
    private int lowerBound(int target) {
        int idx = -1;
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] <= target) {
                idx = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
    private int upperBound(int target) {
        int idx = -1;
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] >= target) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}