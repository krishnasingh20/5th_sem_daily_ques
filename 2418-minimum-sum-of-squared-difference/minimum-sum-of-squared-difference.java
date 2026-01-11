class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long)k1+k2;
        long[] diff = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i]-nums2[i]);
            sum += diff[i];
        }
        if(sum <= k) {
            return 0;
        }
        Arrays.sort(diff);
        long[] prefix = new long[n+1];
        for(int i = n-1; i >= 0; i--) {
            prefix[i] = diff[i];
            prefix[i] += prefix[i+1];
        }
        int idx = -1;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            long left = prefix[mid];
            long right = prefix[mid+1];
            long curr = left-right;
            long req = (n-(mid+1))*curr;
            if(k >= right-req) {
                idx = mid;
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        for(int i = idx+1; i < n; i++) {
            long d = diff[i]-diff[idx];
            k -= d;
            diff[i] = diff[idx];
        }
        if(k > 0) {
            long len = n - idx;
            long extra = k % len;
            k = k/len;
            for(int i = idx; i < n; i++) {
                if(extra > 0) {
                    diff[i] -= 1;
                    extra--;
                }
                diff[i] -= k;
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans += (diff[i]*diff[i]);
        }
        return ans;
    }
}