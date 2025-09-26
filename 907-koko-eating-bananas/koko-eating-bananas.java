class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long ans = 0;
        long low = 1;
        long high = 0;
        for(int pile: piles) {
            high = Math.max(high, pile);
        }
        while(low <= high) {
            long mid = low +(high - low) / 2;
            if(isPossible(piles, mid) <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
    public long isPossible(int[] piles, long k) {
        long h = 0;
        for(int pile: piles) {
            h += (pile/k);
            if(pile % k != 0) {
                h++;
            }
        }
        return h;
    }
}