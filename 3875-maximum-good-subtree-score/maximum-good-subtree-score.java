class Solution {

    static final int mod = 1000000007;

    List<List<Integer>> adj = new ArrayList<>();
    int score = 0;

    public int goodSubtreeSum(int[] vals, int[] par) {

        int n = vals.length;

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            adj.get(par[i]).add(i);
        }

        dfs(0, vals);

        return score;
    }

    private List<Integer> dfs(int src, int[] vals) {
        List<Integer> arr = new ArrayList<>();
        arr.add(src);

        for(int nbrs: adj.get(src)) {
            arr.addAll(dfs(nbrs, vals));
        }

        dp = new Integer[arr.size()][1024];

        score = (score + maxScore(arr, 0, 0, vals)) % mod;

        return arr;
    }

    Integer[][] dp;

    private int maxScore(List<Integer> arr, int i, int mask, int[] vals) {
        if(i == arr.size()) {
            return 0;
        }

        if(dp[i][mask] != null) {
            return dp[i][mask];
        }

        int currMask = getMask(vals[arr.get(i)]);
        int val = vals[arr.get(i)];

        
        if(currMask == -1) {
           currMask = 0;
           val = 0;
        }

        int pick = 0;
        if((mask & currMask) == 0) {
            pick = (val + maxScore(arr, i+1, (mask | currMask), vals)) % mod;
        }

        int notPick = maxScore(arr, i+1, mask, vals) % mod;

        return dp[i][mask] = Math.max(pick, notPick);
    }

    private int getMask(int num) {
        int mask = 0;
        while(num > 0) {
            int rem = num % 10;
            if((mask & (1 << rem)) != 0) {
                return -1;
            }

            mask |= (1 << rem);
            num /= 10;
        }

        return mask;
    }
}