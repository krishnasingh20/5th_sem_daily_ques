class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // these question is based on logic of IPO and i used same concept to solve it, the only difference is that in ipo we have to check with aur  current capital we have in these we will check that how much max profit ith worker can get with max difficulty worker[i]
        int[][] arr = new int[profit.length][2];
        for(int i = 0; i < profit.length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(worker);
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        int j = 0;
        int ans = 0;
        int maxProfit = 0;
        for(int i = 0; i < worker.length; i++) {
            while(j < arr.length && worker[i] >= arr[j][0]) {
                maxProfit = Math.max(maxProfit, arr[j][1]);
                j++;
            }
            ans += maxProfit;
        }
        return ans;
    }
}