class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            nums[i] = GCD(nums[i], max);
        }

        Arrays.sort(nums);

        long ans = 0;
        int i = 0;
        int j = n - 1;

        while(i < j) {
            ans += GCD(nums[i], nums[j]);
            i++;
            j--;
        }

        return ans;

    }
    private int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}