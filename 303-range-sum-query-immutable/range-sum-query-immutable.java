class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int l, int r) {
        return prefix[r] - (l == 0 ? 0 : prefix[l-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */