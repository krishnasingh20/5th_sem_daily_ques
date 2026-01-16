class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        // x+y=goal
        // y = goal-x, where x is current array sum
        long sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum == goal) {
            return 0;
        }
        long y = Math.abs(goal-sum);
        int ans = (int)(y/limit);
        if(y % limit > 0) {
            ans++;
        }
        return ans;
    }
}