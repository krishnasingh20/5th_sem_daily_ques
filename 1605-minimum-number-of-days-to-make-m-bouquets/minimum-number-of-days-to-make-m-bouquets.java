class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int low = 1;
        int high = -1;
        for(int bloom: bloomDay) {
            high = Math.max(bloom, high);
        }
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean possible(int[] bloomDay, int mid, int m, int k) {
        int bloom = 0;
        int m1 = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                bloom++;
            }
            else {
                m1 += bloom/k;
                bloom = 0;
            }
            if(m1 >= m) {
                return true;
            }
        }
        if(bloom > 0) {
            m1 += bloom/k;
        }
        return m1 >= m;
    }
}