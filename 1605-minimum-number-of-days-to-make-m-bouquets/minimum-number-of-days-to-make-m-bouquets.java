class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) {
            return -1;
        }
        int ans = -1;
        int low = 1;
        int high = 0;
        for(int num: bloomDay) {
            high = Math.max(high, num);
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, bloomDay, k);
            if(c >= m) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int count(int mid, int[] arr, int k) {
        int c = 0;
        int c1 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > mid) {
                c += (c1 / k);
                c1 = 0;
            }
            else {
                c1++;
            }
        }
        c += (c1 / k);
        return c;
    }
}