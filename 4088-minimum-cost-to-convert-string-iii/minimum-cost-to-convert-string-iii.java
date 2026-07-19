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

        dp = new int[source.length()];
        Arrays.fill(dp, -1);

        int ans = minCost(0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int minCost(int i) {
        if (i == src.length()) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int match = Integer.MAX_VALUE;
        if (src.charAt(i) == des.charAt(i)) {
            match = minCost(i + 1);
        }

        //apply rules
        int replace = Integer.MAX_VALUE;

        for (int j = 0; j < rules.size(); j++) {

            String pattern = rules.get(j).get(0);
            String replacement = rules.get(j).get(1);

            if (i + pattern.length() <= src.length()) {

                int star = 0;
                boolean flag = false;

                for (int k = 0; k < pattern.length(); k++) {
                    if (des.charAt(i + k) != replacement.charAt(k)) {
                        flag = true;
                        break;
                    }

                    if (pattern.charAt(k) == '*') {
                        star++;
                    } else if (pattern.charAt(k) != src.charAt(i + k)) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    int curr = minCost(i + pattern.length());

                    if (curr != Integer.MAX_VALUE) {
                        curr += star + costs[j];
                    }

                    replace = Math.min(replace, curr);
                }
            }
        }

        return dp[i] = Math.min(replace, match);
    }
}