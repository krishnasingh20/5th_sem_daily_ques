class Solution {
    int n;
    int[] free;
    Integer[][][] dp;

    public int maximumSaleItems(int[][] items, int budget) {
        n = items.length;
        int m = 1501;
        int max = 0;
        int[] freq = new int[m];
        free = new int[n];

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        for(int i = 0; i < n; i++) {
            freq[items[i][0]]++;
            max = Math.max(max, items[i][0]);
        }

        for(int i = 0; i < n; i++) {

            int j = 1;
            int x = items[i][0];

            while(x*j <= max) {
                free[i] += freq[x*j];
                j++;
            }

            free[i]--;
        }

        dp = new Integer[n][2][budget+1];

        return maxSaleItem(items, 0, 0, budget);
    }

    // state represent that if we come first time at any index then we can take free copies count also after buying one copiy of ith item other wise we get only one copy that we purchased

    public int maxSaleItem(int[][] items, int i, int state, int budget) {
        if(i == n || budget < items[i][1]) {
            return 0;
        }

        if(dp[i][state][budget] != null) {
            return dp[i][state][budget];
        }

        int curr = 0;

        if(items[i][1] <= budget) {
            if(state == 0) {
                curr = 1 + free[i];
            }
            else {
                curr++;
            }

            curr += maxSaleItem(items, i, 1, budget - items[i][1]);
        }

        int skip = maxSaleItem(items, i+1, 0, budget);

        return dp[i][state][budget] = Math.max(skip, curr);
    }
} 