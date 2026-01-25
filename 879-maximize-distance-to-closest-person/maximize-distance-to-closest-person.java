class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] suffix = new int[n+1];
        suffix[n] = -1;
        for(int i = n-1; i >= 0; i--) {
            if(seats[i] == 1) {
                suffix[i] = i;
            }
            else {
                suffix[i] = suffix[i+1];
            }
        }
        int ans = 0;
        int prefix = -1;
        for(int i = 0; i < n; i++) {
            if(seats[i] == 1) {
                prefix = i;
                continue;
            }
            int dist1 = prefix == -1?Integer.MAX_VALUE:i-prefix;
            int dist2 = suffix[i+1] == -1?Integer.MAX_VALUE:suffix[i+1]-i;
            ans = Math.max(ans, Math.min(dist1, dist2));
        }
        return ans;
    }
}