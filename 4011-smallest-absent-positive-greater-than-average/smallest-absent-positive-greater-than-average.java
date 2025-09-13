class Solution {
    public int smallestAbsent(int[] nums) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            set.add(nums[i]);
        }
        int val = (int)Math.ceil(1.0*sum/nums.length);
        if(val == sum/nums.length) {
            val++;
        }
        if(val <= 0) {
            val = 1;
        }
        while(set.contains(val)) {
            val++;
        }
        return val;
    }
}