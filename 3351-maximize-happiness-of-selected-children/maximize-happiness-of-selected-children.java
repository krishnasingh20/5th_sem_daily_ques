class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int i = 0;
        long ans = 0;
        while(i < k) {
            if(happiness[n - 1 - i] - i >= 0) {
                ans += happiness[n - 1 - i] - i;
            }
            i++;
        }
        return ans;
    }
}