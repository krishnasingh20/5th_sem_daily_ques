class Solution {
    List<List<String>> rules;
    int[] costs;
    String src;
    String des;
    int[] dp;

    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {

        this.rules = rules;
        this.costs = costs;
        this.src = source;
        this.des = target;

        return bottomUp();
    }

    private int bottomUp() {
        int n = src.length();

        dp = new int[n+1];

        for(int i = n - 1; i >= 0; i--) {

            int match = Integer.MAX_VALUE;
            if(src.charAt(i) == des.charAt(i)) {
                match = dp[i+1];
            }

            // apply rules
            int replace = Integer.MAX_VALUE;

            for(int j = 0; j < rules.size(); j++) {

                String pattern = rules.get(j).get(0);
                String replacement = rules.get(j).get(1);

                if(i+pattern.length() <= n) {
                    int star = 0;
                    boolean flag = false;

                    for(int k = 0; k < pattern.length(); k++) {
                        if(replacement.charAt(k) != des.charAt(i+k)) {
                            flag = true;
                            break;
                        }

                        if(pattern.charAt(k) == '*') {
                            star++;
                        }
                        else if(pattern.charAt(k) != src.charAt(i+k)) {
                            flag = true;
                            break;
                        }
                    }

                    if(!flag) {
                        int curr = dp[i+pattern.length()];
                        if(curr != Integer.MAX_VALUE) {
                            curr += star + costs[j];
                        }
                        replace = Math.min(replace, curr);
                    }
                }
            }

            dp[i] = Math.min(match, replace);
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}