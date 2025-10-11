class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // main logic behind (values[i] + i), evry time for i < j we always try ot carry maximum value of values[i] + i so that we can maximize aur answer
        int ans = 0;
        int max = values[0] + 0;
        for(int i = 1; i < values.length; i++) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}