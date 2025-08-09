class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 0;
        Arrays.sort(time);
        long low = time[0];
        long high = 0;
        for(int i = 0; i < time.length; i++) {
            high += time[i];
        } high *= totalTrips;
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
            long possibleTrip = 0;
            for(int i = 0; i < time.length; i++) {
                possibleTrip += (mid / time[i]);
                if(possibleTrip >= totalTrips) {
                    return true;
                }
            }
            return false;
        }
}