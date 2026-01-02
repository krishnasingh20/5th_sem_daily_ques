class Solution {
    public int repeatedNTimes(int[] nums) {
        int max = -1;
        int n = nums.length/2;
        for(int num:nums) {
            max = Math.max(max, num);
        }
        int[] freq = new int[max+1];
        for(int num: nums) {
            freq[num]++;
            if(freq[num] == n) {
                return num;
            }
        }
        return -1;
    }
}