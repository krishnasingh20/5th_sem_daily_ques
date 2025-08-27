class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long diff = Long.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long curr = 0;
        for(int i = 0; i < n; i++) {
            curr += nums[i];
            if(i == n - 1) {
                if(curr/(i+1) < diff) {
                    idx = i;
                }
                continue;
            }
            if(Math.abs((curr/(i+1))- ((sum-curr)/(n-i-1))) < diff) {
                diff = Math.abs((curr/(i+1))- ((sum-curr)/(n-i-1)));
                idx = i;
            }
        }
        return idx;
    }
}