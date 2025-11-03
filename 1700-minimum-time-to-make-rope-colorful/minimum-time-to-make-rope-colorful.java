class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        int i = 0;
        while(i < n - 1) {
            if(colors.charAt(i) == colors.charAt(i+1)) {
                int sum = neededTime[i];
                int max = neededTime[i];
                while(i < n - 1 && colors.charAt(i) == colors.charAt(i+1)) {
                    sum += neededTime[i+1];
                    max = Math.max(neededTime[i+1], max);
                    i++;
                }
                sum -= max;
                ans += sum;
                continue;
            }
            i++;
        }
        return ans;
    }
}