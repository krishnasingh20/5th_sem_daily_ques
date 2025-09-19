class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 0;
        int high = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(houses, heaters, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] houses, int[] heaters, int mid) {
        int i = 0;
        int count = 0;
        for(int j = 0; j < houses.length;) {
            if(i >= heaters.length) {
                break;
            }
            else if(houses[j] >= heaters[i]-mid && houses[j] <= heaters[i]+mid) {
                count++;
                j++;
            }
            else {
                i++;
            }
        }
        return count == houses.length;
    }
}