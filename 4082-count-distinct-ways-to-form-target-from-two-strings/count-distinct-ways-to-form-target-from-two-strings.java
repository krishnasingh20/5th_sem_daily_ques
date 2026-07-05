class Solution {
    static final int MOD = 1000000007;
    List<Integer>[] arr1 = new ArrayList[26];
    List<Integer>[] arr2 = new ArrayList[26];
    int[][][] dp;
    public int interleaveCharacters(String s1, String s2, String target) {
        for(int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i)-'a';
            if(arr1[x] == null) {
                arr1[x] = new ArrayList<>();
            }
            arr1[x].add(i);
        }
        for(int i = 0; i < s2.length(); i++) {
            int x = s2.charAt(i)-'a';
            if(arr2[x] == null) {
                arr2[x] = new ArrayList<>();
            }
            arr2[x].add(i);
        }

        dp = new int[target.length()][s1.length()+1][s2.length()+1];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }

        return ways(target, 0, -1, -1);
        
    }

    public int ways(String s, int i, int j, int k) {
        if(i == s.length()) {
            return (j >= 0 && k >= 0) ? 1 : 0;
        }
        if(dp[i][j+1][k+1] != -1) {
            return dp[i][j+1][k+1];
        }
        int x = s.charAt(i)-'a';
        List<Integer> l1 = arr1[x];
        List<Integer> l2 = arr2[x];
        int idx1 = search(l1, j);
        int ans = 0;
        if(idx1 != -1) {
            for(int l = idx1; l < l1.size(); l++) {
                int curr = ways(s, i+1, l1.get(l), k);
                ans = (ans + curr) % MOD;
            }
        }

        int idx2 = search(l2, k);
        if(idx2 != -1) {
            for(int l = idx2; l < l2.size(); l++) {
                int curr = ways(s, i+1, j, l2.get(l));
                ans = (ans + curr) % MOD;
            }
        }

        return dp[i][j+1][k+1] = ans;
    }

    public int search(List<Integer> ll, int val) {
        if(ll == null) {
            return -1;
        }
        int low = 0;
        int high = ll.size()-1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(ll.get(mid) > val) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}