class Solution {
    public long maxTotal(int[] value, int[] limits) {
        int n = limits.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = limits[i];
            arr[i][1] = value[i];
        }
        Arrays.sort(arr, (a, b)->a[0] == b[0]?b[1]-a[1]:a[0]-b[0]);
        long ans = 0;
        for(int i = 0; i < n;) {
            int x = arr[i][0];
            int limit = x;
            while(i < n && arr[i][0] == x && limit > 0) {
                ans += arr[i][1];
                limit--;
                i++;
            }
            while(i < n && arr[i][0] == x) {
                i++;
            }
        }
        return ans;
    }
}