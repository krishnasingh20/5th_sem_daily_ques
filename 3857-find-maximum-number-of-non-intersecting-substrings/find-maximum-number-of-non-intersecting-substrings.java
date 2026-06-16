class Solution {
    public int maxSubstrings(String s) {
        int n = s.length();

        if(n < 4) {
            return 0;
        }

        int[] dp = new int[n];
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i)-'a';

            if(!map.containsKey(x)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(x, set);

                if(i > 0) {
                    dp[i] = dp[i-1];
                }

                continue;
            }

            TreeSet<Integer> set = map.get(x);
            Integer idx = set.floor(i-3);

            if(idx == null) {
                set.add(i);

                if(i > 0) {
                    dp[i] = dp[i-1];
                }
                
                continue;
            }

            int curr = (idx > 0 ? dp[idx - 1] : 0) + 1;
            dp[i] = Math.max(dp[i-1], curr);

            set.add(i);
        }

        return dp[n-1];
    }
}