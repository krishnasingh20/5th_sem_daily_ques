class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] min = new int[n+1];
        min[n] = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(min[i+1], arr[i]);
        }

        int ans = 0;
        int i = 0;
        int max = 0;

        while(i < n) {
            max = Math.max(max, arr[i]);
            if(max <= min[i+1]) {
                max = 0;
                ans++;
            }
            i++;
        }

        return ans;
    }
}