class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i++) {
            if(security[i] <= security[i-1]) {
                prefix[i] = prefix[i-1]+1;
            }
            else {
                prefix[i] = 1;
            }
        }
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(security[i] <= security[i+1]) {
                suffix[i] = suffix[i+1] + 1;
            }
            else {
                suffix[i] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(time == 0) {
            for(int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }
        for(int i = 1; i < n-1; i++) {
            if(prefix[i-1] >= time && suffix[i+1] >= time && security[i] <= security[i-1] && security[i] <= security[i+1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}