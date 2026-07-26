class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int curr = 1;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            curr *= nums[i];
            ans = Math.max(ans, curr);
            if(curr == 0) {
                curr = 1;
            }
        }

        curr = 1;

        for(int i = n - 1; i >= 0; i--) {
            curr *= nums[i];
            ans = Math.max(ans, curr);
            if(curr == 0) {
                curr = 1;
            }
        }

        return ans;
    }
}