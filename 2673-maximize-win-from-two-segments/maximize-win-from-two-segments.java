class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            int idx = upperBound(prizePositions, i, k);
            if(idx - i + 1 == n) {
                return n;
            }
            prefix[i] = idx - i + 1;
            prizePositions[i] = idx;
        }
        for(int i = n - 1; i >= 0; i--) {
            prefix[i] = Math.max(prefix[i+1], prefix[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int curr = (prizePositions[i] - i + 1) + prefix[prizePositions[i]+1];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
    public int upperBound(int[] positions, int i, int k) {
        int low = i;
        int high = positions.length-1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(positions[mid] - positions[i] <= k) {
                idx = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
}