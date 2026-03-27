class Solution {

    List<List<Integer>> adj = new ArrayList<>();
    int[] masks;
    long score = 0;
    List<Integer> arr = new ArrayList<>();

    public int goodSubtreeSum(int[] vals, int[] par) {

        int n = vals.length;
        masks = new int[n];

        for(int i = 0; i < n; i++) {

            int mask = 0;
            int num = vals[i];

            while(num > 0) {
                if((mask & (1 << (num % 10))) != 0) {
                    vals[i] = 0;
                    mask = 0;
                    break;
                }
                mask |= (1 << (num % 10));
                num /= 10;
            }

            masks[i] = mask;
        }

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            adj.get(par[i]).add(i);
        }

        for(int i = 0; i < n; i++) {
            arr.clear();

            dfs(i, vals);

            dp = new Long[arr.size()][1024];

            score += maxScore(0, 0, vals);

        }

        return (int)(score % 1000000007);
    }

    Long[][] dp;

    private void dfs(int src, int[] vals) {
        for(int nbrs: adj.get(src)) {
            dfs(nbrs, vals);
        }
        arr.add(src);
    }

    private long maxScore(int i, int mask, int[] vals) {
        if(i == arr.size()) {
            return 0;
        }

        if(dp[i][mask] != null) {
            return dp[i][mask];
        }

        long pick = 0;
        if((mask & masks[arr.get(i)]) == 0) {
            pick = vals[arr.get(i)] + maxScore(i+1, (mask | masks[arr.get(i)]), vals);
        }
        long notPick = maxScore(i+1, mask, vals);

        return dp[i][mask] = Math.max(pick, notPick);
    }
}