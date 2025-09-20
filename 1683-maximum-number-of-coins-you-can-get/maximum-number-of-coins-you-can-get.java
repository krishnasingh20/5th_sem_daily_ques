class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int i = 0;
        int j = piles.length - 2;
        while(i < j) {
            ans += piles[j];
            j -= 2;
            i++;
        }
        return ans;
    }
}