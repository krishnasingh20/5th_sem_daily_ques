class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int t: time) {
            min = Math.min(min, t);
            max = Math.max(max, t);
        }
        long low = min;
        long high = (long)max * totalTrips;
        long ans = 0;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(ispossible(time, mid, totalTrips)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] time, long mid, int totalTrips) {
        long possibletrip = 0;
        for(int t: time) {
            possibletrip += (mid / t);
            if(possibletrip >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}