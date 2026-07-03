class Solution {
    public boolean carPooling(int[][] trips, int cap) {
        int max = 0;
        int n = trips.length;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, trips[i][2]);
        }

        int[] diff = new int[max+1];

        for(int i = 0; i < n; i++) {
            int l = trips[i][1];
            int r = trips[i][2];
            int val = trips[i][0];
            diff[l] += val;
            diff[r] -= val;
        }

        for(int i = 1; i <= max; i++) {
            diff[i] += diff
            [i-1];
        }

        for(int i = 0; i <= max; i++) {
            if(diff[i] > cap) {
                return false;
            }
        }

        return true;
    }
}