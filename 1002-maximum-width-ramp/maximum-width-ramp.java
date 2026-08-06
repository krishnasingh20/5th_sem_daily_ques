class Solution {
    public int maxWidthRamp(int[] nums) {
        int max  = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int[] ramp = new int[max+1];
        Arrays.fill(ramp, -1);
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(ramp[num] == -1) {
                while(num <= max && ramp[num] == -1) {
                    ramp[num] = i;
                    num++;
                }
            }
            ans = Math.max(ans, i - ramp[nums[i]]);
        }

        return ans;
    }
}