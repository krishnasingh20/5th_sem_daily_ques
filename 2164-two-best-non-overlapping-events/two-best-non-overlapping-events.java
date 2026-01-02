class Solution {
    public int maxTwoEvents(int[][] arr) {
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1][2];
        for(int i = n-2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], arr[i][2]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int curr = arr[i][2];
            int idx = binarySearch(arr, arr[i][1], i+1, n-1);
            if(idx != -1) {
                curr += suffix[idx];
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
    public int binarySearch(int[][] arr, int end, int low, int high) {
        int idx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid][0] > end) {
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