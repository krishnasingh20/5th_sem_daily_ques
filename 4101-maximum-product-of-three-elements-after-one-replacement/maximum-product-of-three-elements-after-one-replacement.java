class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // case 1--> all number is from front
        long c1 = Math.abs((long)nums[0]*nums[1]*100000);
        // case 2--> all number is from back
        long c2 = Math.abs((long)nums[n-1]*nums[n-2]*100000);
        // case 3--> 1 number from front and 2 number from back
        long c3 = 0;
        int min1 = Math.min(Math.min(Math.abs(nums[0]), Math.abs(nums[n-2])), Math.abs(nums[n-1]));
        if(Math.abs(nums[0]) == min1) {
            c3 = Math.abs((long)nums[n-1]*nums[n-2]*100000);
        }
        else if(Math.abs(nums[n-1]) == min1) {
            c3 = Math.abs((long)nums[0]*nums[n-2]*100000);
        }
        else {
            c3 = Math.abs((long)nums[0]*nums[n-1]*100000);
        }
        //case 4--> 2 number from front and 1 number from back
        long c4 = 0;
        int min2 = Math.min(Math.min(Math.abs(nums[0]), Math.abs(nums[1])), Math.abs(nums[n-1]));
        if(Math.abs(nums[0]) == min2) {
            c4 = Math.abs((long)nums[1]*nums[n-1]*100000);
        }
        else if(Math.abs(nums[1]) == min2) {
            c4 = Math.abs((long)nums[0]*nums[n-1]*100000);
        }
        else {
            c4 = Math.abs((long)nums[0]*nums[1]*100000);
        }

        return Math.max(Math.max(c1, c2), Math.max(c3, c4));
    }
}