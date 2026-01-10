class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int neg = 0;
        long ans = 1;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                neg++;
            }
            if(nums[i] > 0) {
                flag = true;
                ans *= nums[i];
            }
        }
        if((neg & 1) == 1) {
            neg--;
        }
        int i = 0;
        while(neg-- > 0) {
            flag = true;
            ans *= nums[i];
            i++;
        }
        if(!flag) {
            return 0;
        }
        return ans;
    }
}